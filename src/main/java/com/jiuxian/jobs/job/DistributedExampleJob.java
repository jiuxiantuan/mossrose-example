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
		return Splitter.on(" ").splitToList("A B C D E F G H I J K L M N O P Q R S T U");
	}

	@Override
	public void execute(String item) {
		if ("D".equals(item)) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		LOGGER.info("DistributedJob: {}", StructuredArguments.value("item", item));
	}

}
