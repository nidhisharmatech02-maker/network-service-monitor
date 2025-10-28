package com.example.nsm.check;

import com.example.nsm.model.HealthMetric;
import com.example.nsm.storage.MetricsRepository;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.util.concurrent.Callable;

public class HealthCheckTask implements Callable<HealthMetric> {
    private final String serviceName;
    private final String endpoint;
    private final MetricsRepository repo;
    private final int timeoutMs;

    public HealthCheckTask(String serviceName, String endpoint, MetricsRepository repo, int timeoutMs) {
        this.serviceName = serviceName;
        this.endpoint = endpoint;
        this.repo = repo;
        this.timeoutMs = timeoutMs;
    }

    @Override
    public HealthMetric call() {
        boolean healthy = false;
        long latency = -1;
        Instant now = Instant.now();
        try {
            long start = System.currentTimeMillis();
            URL url = new URL(endpoint);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(timeoutMs);
            con.setReadTimeout(timeoutMs);
            con.connect();
            int code = con.getResponseCode();
            latency = System.currentTimeMillis() - start;
            healthy = (code >= 200 && code < 400);
        } catch (Exception e) {
            healthy = false;
        }
        HealthMetric metric = new HealthMetric(serviceName, endpoint, healthy, latency, now);
        try {
            repo.save(metric);
        } catch (Exception e) {
            // repository errors shouldn't stop health checks
            System.err.println("Failed to save metric: " + e.getMessage());
        }
        return metric;
    }
}
