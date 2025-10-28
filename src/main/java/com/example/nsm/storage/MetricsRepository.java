package com.example.nsm.storage;

import com.example.nsm.model.HealthMetric;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Repository
public class MetricsRepository {
    private final JdbcTemplate jdbc;

    public MetricsRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(HealthMetric m) {
        String sql = "INSERT INTO SERVICE_METRICS (SERVICE_NAME, ENDPOINT, HEALTHY, LATENCY_MS, CHECKED_AT) VALUES (?, ?, ?, ?, ?)";
        jdbc.update(sql, m.getServiceName(), m.getEndpoint(), m.isHealthy() ? 1 : 0, m.getLatencyMs(), Timestamp.from(m.getCheckedAt()));
    }

    public List<Map<String,Object>> findRecent(int limit) {
        String sql = "SELECT * FROM (SELECT * FROM SERVICE_METRICS ORDER BY CHECKED_AT DESC) WHERE ROWNUM <= ?";
        return jdbc.queryForList(sql, limit);
    }
}
