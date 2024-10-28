package com.ilan.config;

import lombok.RequiredArgsConstructor;
import net.sky.config.CustomScanConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
public class CustomScanConfigTest {

    private final CustomScanConfig customScanConfig;

    @Test
    void propertySourcesPlaceholder() {
        customScanConfig.propertySourcesPlaceholderConfigurer();
    }
}
