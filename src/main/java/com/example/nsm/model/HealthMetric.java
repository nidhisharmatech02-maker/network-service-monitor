package com.example.nsm.model;

import java.time.Instant;

public class HealthMetric {
    private String serviceName;
    private String endpoint;
    private boolean healthy;
    private long latencyMs;
    private Instant checkedAt;

    public HealthMetric() {}

    public HealthMetric(String serviceName, String endpoint, boolean healthy, long latencyMs, Instant checkedAt) {
        this.serviceName = serviceName;
        this.endpoint = endpoint;
        this.healthy = healthy;
        this.latencyMs = latencyMs;
        this.checkedAt = checkedAt;
    }

    // getters and setters
    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    public String getEndpoint() { return endpoint; }
    public void setEndpoint(String endpoint) { this.endpoint = endpoint; }
    public boolean isHealthy() { return healthy; }
    public void setHealthy(boolean healthy) { this.healthy = healthy; }
    public long getLatencyMs() { return latencyMs; }
    public void setLatencyMs(long latencyMs) { this.latencyMs = latencyMs; }
    public java.time.Instant getCheckedAt() { return checkedAt; }
    public void setCheckedAt(java.time.Instant checkedAt) { this.checkedAt = checkedAt; }
}
