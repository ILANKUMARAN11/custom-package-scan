package com.ilan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("dev")
@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Slf4j
class CustomComponentScanTest {

	private final ApplicationContext applicationContext;

	@Test
	void beanCount() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		Long beanCount = Arrays.stream(allBeanNames)
				.filter(bean -> applicationContext.getType(bean).getPackageName().startsWith("net.sky.service")
						|| applicationContext.getType(bean).toString().contains("org.tcs.service"))
				.peek(bean -> {
					log.info(">>>> BeanType:: {}, Bean Name :: {}" , applicationContext.getType(bean) , bean);
				}).count();

		assertEquals(4, beanCount);
	}

}
