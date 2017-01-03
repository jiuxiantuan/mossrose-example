package com.jiuxian.jobs.job;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jiuxian.mossrose.job.SimpleJob;

public class SimpleExampleJob implements SimpleJob {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleExampleJob.class);

	@Override
	public Executor executor() {
		return new Executor() {

			@Override
			public void execute() {
				System.out.println(this);
				try {
					Thread.sleep(RandomUtils.nextInt(1, 5) * 1000);
				} catch (InterruptedException e) {
				}
				LOGGER.info("SimpleJob");
			}
		};
	}

}
