package com.jiuxian.jobs.job;

import com.jiuxian.mossrose.job.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleExampleJob implements SimpleJob {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleExampleJob.class);

	@Override
	public Executor executor() {
		return new Executor() {

			@Override
			public void execute() {
				LOGGER.info("SimpleJob");
			}
		};
	}

}
