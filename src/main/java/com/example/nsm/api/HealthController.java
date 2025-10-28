package com.example.nsm.api;

import com.example.nsm.check.HealthCheckService;
import com.example.nsm.model.HealthMetric;
import com.example.nsm.storage.MetricsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class HealthController {
    private final HealthCheckService checker;
    private final MetricsRepository repo;

    public HealthController(HealthCheckService checker, MetricsRepository repo) {
        this.checker = checker;
        this.repo = repo;
    }

    @GetMapping("/health/run")
    public ResponseEntity<List<HealthMetric>> runChecks() {
        return ResponseEntity.ok(checker.runChecks());
    }

    @GetMapping("/health/targets")
    public ResponseEntity<Map<String,String>> targets() {
        return ResponseEntity.ok(checker.getTargets());
    }

    @PostMapping("/health/targets")
    public ResponseEntity<Void> addTarget(@RequestBody Map<String,String> body) {
        String name = body.get("name");
        String endpoint = body.get("endpoint");
        checker.addTarget(name, endpoint);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/metrics/recent")
    public ResponseEntity<List<Map<String,Object>>> recentMetrics(@RequestParam(defaultValue="10") int limit) {
        return ResponseEntity.ok(repo.findRecent(limit));
    }
}
