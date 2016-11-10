package com.jiuxian.jobs.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHolder implements ApplicationContextAware {

	private static ApplicationContext staticApplicationContext;

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) staticApplicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> clazz) {
		return staticApplicationContext.getBean(clazz);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.staticApplicationContext = applicationContext;
	}

}
