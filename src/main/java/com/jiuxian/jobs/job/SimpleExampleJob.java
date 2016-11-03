package com.jiuxian.jobs.job;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jiuxian.mossrose.job.SimpleJob;

import net.logstash.logback.argument.StructuredArguments;

public class SimpleExampleJob implements SimpleJob {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleExampleJob.class);

	@Override
	public void execute() {
		LOGGER.info("SimpleJob: {}", StructuredArguments.value("UUID", UUID.randomUUID()));
	}

}
