package com.jiuxian.jobs.job;

import java.io.Serializable;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jiuxian.mossrose.job.SimpleJob;

import net.logstash.logback.argument.StructuredArguments;

public class SimpleExampleJob implements SimpleJob<Serializable> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleExampleJob.class);

	@Override
	public Executor<Serializable> executor() {
		return new Executor<Serializable>() {

			@Override
			public void execute(Serializable item) {
				LOGGER.info("SimpleJob: {}", StructuredArguments.value("UUID", UUID.randomUUID()));
			}
		};
	}

}
