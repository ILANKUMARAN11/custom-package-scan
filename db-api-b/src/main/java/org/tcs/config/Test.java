/*
package org.tcs.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration; import org.springframework.context.annotation. PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
@Configuration
@PropertySource ("classpath: application.properties")
public class Test {

    @Value("${app.base.package}")
    private String basePackage;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ComponentScanConfig componentScanConfig() {
        return new ComponentScanConfig(basePackage);
    }

    public static class ComponentScanConfig {
        public ComponentScanConfig(String basePackage) {
            // Custom logic to set up component scanning
        }

    }

}
*/
