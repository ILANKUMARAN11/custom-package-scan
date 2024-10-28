package com.ilan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class ComponentScanApplication implements ApplicationContextAware {

    ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(ComponentScanApplication.class, args);
    }


    @Bean
    public CommandLineRunner startup() {

        return args -> {
            String[] allBeanNames = applicationContext.getBeanDefinitionNames();
            Arrays.stream(allBeanNames)
                    .filter(bean -> applicationContext.getType(bean).toString().contains("net.sky.service")
                    || applicationContext.getType(bean).toString().contains("org.tcs.service"))
                    .forEach(bean -> {
                        log.info(">>>> CommandLineRunner BeanType:: {}, Bean Name :: {}" , applicationContext.getType(bean) , bean);
                    });

        };

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
