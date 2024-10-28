package net.sky;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@AutoConfiguration
@ComponentScan("net.sky.config")
public class AppConfig {

    @Configuration
    //@EnableConfigurationProperties(AppProperties.class)
    public static class CustomScanConfig {

        //@Autowired
        //AppProperties appProperties;


        @Bean
        @ConditionalOnMissingBean(name = "propertySourcesPlaceholderConfigurer")
        public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
            return new PropertySourcesPlaceholderConfigurer();
        }

        @ComponentScan(basePackages = "${app.basePackagesToScan:net.sky.service}")
        public static class ComponentScanConfig{

        }

    }
}
