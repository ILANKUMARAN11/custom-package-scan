package com.ilan.config;

import net.sky.config.CustomScanConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomScanConfigTest {

    @Autowired
    CustomScanConfig customScanConfig;

    @Test
    void propertySourcesPlaceholder() {
        customScanConfig.propertySourcesPlaceholderConfigurer();
    }
}
