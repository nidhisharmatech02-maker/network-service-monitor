package com.example.nsm;

import com.example.nsm.api.HealthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NetworkServiceMonitorApplicationTests {

    @Autowired
    private HealthController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }
}
