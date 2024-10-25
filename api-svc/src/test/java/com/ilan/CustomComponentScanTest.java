package com.ilan;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("dev")
@SpringBootTest
class CustomComponentScanTest {

	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	ApplicationContext applicationContext;

	@Test
	void beanCount() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		Long beanCount = Arrays.stream(allBeanNames)
				.filter(bean -> applicationContext.getType(bean).toString().contains("net.sky.service"))
				.peek(bean -> {
					log.info(">>>> BeanType:: {}, Bean Name :: {}" , applicationContext.getType(bean) , bean);
				}).count();

		assertEquals(2, beanCount);
	}

}
