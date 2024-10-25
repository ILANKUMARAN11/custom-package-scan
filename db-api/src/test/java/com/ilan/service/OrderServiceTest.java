package com.ilan.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.WHEN_AVAILABLE)
class OrderServiceTest {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	ApplicationContext applicationContext;

	@Test
	void beanCount() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		Long beanCount = Arrays.stream(allBeanNames)
				.filter(bean -> applicationContext.getType(bean).getPackageName().startsWith("net.sky.service"))
				.peek(bean -> {
					log.info(">>>> BeanType:: {}, Bean Name :: {}" , applicationContext.getType(bean) , bean);
				}).count();

		assertEquals(3, beanCount);
	}

}
