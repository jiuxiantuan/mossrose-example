package com.jiuxian.jobs.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jiuxian.mossrose.MossroseProcess;

/**
 * Main entrance of mossrose
 * 
 * @author <a href="mailto:wangyuxuan@jiuxian.com">Yuxuan Wang</a>
 *
 */
public class MossroseExampleEntrance {
	private static final String SRPING_ROOT_XML = "classpath:spring.xml";

	private static final Logger LOGGER = LoggerFactory.getLogger(MossroseExampleEntrance.class);

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(SRPING_ROOT_XML)) {
			context.registerShutdownHook();
			context.start();

			context.getBean(MossroseProcess.class).run();
			
			LOGGER.info("mossrose jobs 启动成功");
			Object lock = new Object();
			synchronized (lock) {
				try {
					while (true)
						lock.wait();
				} catch (InterruptedException e) {
					LOGGER.error(e.getMessage(), e);
				}
			}

		} catch (RuntimeException e) {
			LOGGER.error("Spring 启动错误", e);
		}

	}

}
