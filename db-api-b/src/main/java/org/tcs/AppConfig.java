package org.tcs;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;

@AutoConfiguration
@ImportAutoConfiguration(CustomScanConfig.class)
public class AppConfig {

}
