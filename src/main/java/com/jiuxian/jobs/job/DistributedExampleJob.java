package com.jiuxian.jobs.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;
import com.jiuxian.mossrose.job.DistributedJob;

import net.logstash.logback.argument.StructuredArguments;

public class DistributedExampleJob implements DistributedJob<String> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleExampleJob.class);

	@Override
	public List<String> slice() {
		return Splitter.on(" ").splitToList("This is a test on the mossrose distributed job, how are you feeling?");
	}

	@Override
	public void execute(String item) {
		LOGGER.info("DistributedJob: {}", StructuredArguments.value("item", item));
	}

}
