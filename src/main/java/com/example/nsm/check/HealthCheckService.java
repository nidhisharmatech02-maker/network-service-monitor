package com.example.nsm.check;

import com.example.nsm.model.HealthMetric;
import com.example.nsm.storage.MetricsRepository;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.*;

@Service
public class HealthCheckService {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final ExecutorService pool = Executors.newFixedThreadPool(10);
    private final MetricsRepository repo;
    private final Map<String, String> targets = new ConcurrentHashMap<>();

    public HealthCheckService(MetricsRepository repo) {
        this.repo = repo;
        // default targets (can be updated via REST)
        targets.put("example-api", "https://httpbin.org/status/200");
        targets.put("example-delay", "https://httpbin.org/delay/1");
        // schedule periodic checks every 30 seconds
        scheduler.scheduleAtFixedRate(this::runChecks, 5, 30, TimeUnit.SECONDS);
    }

    public void addTarget(String name, String endpoint) {
        targets.put(name, endpoint);
    }

    public void removeTarget(String name) {
        targets.remove(name);
    }

    public List<HealthMetric> runChecks() {
        List<Future<HealthMetric>> futures = new ArrayList<>();
        for (Map.Entry<String, String> e : targets.entrySet()) {
            HealthCheckTask task = new HealthCheckTask(e.getKey(), e.getValue(), repo, 5000);
            futures.add(pool.submit(task));
        }
        List<HealthMetric> results = new ArrayList<>();
        for (Future<HealthMetric> f : futures) {
            try {
                results.add(f.get(6, TimeUnit.SECONDS));
            } catch (Exception ex) {
                // on timeout or failure, add a failed metric
                results.add(new HealthMetric("unknown", "unknown", false, -1, java.time.Instant.now()));
            }
        }
        return results;
    }

    @PreDestroy
    public void shutdown() {
        scheduler.shutdownNow();
        pool.shutdownNow();
    }

    public Map<String, String> getTargets() {
        return Collections.unmodifiableMap(targets);
    }
}
