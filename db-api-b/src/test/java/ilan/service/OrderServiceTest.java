package ilan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.WHEN_AVAILABLE)
@RequiredArgsConstructor(onConstructor_ = @__(@Autowired))
@Slf4j
class OrderServiceTest {

	private final ApplicationContext applicationContext;

	@Test
	void beanCount() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		Long beanCount = Arrays.stream(allBeanNames)
				.filter(bean -> applicationContext.getType(bean).getPackageName().startsWith("org.tcs.service"))
				.peek(bean -> {
					log.info(">>>> BeanType:: {}, Bean Name :: {}" , applicationContext.getType(bean) , bean);
				}).count();

		assertEquals(3, beanCount);
	}

}
