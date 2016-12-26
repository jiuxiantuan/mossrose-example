package com.jiuxian.jobs.job;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.base.Splitter;
import com.jiuxian.jobs.bean.IBusinessBean;
import com.jiuxian.mossrose.job.DistributedJob;

public class DistributedExampleJob implements DistributedJob<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleExampleJob.class);

	@Autowired
	private IBusinessBean businessBean;

	@Override
	public Slicer<String> slicer() {
		return new Slicer<String>() {

			@Override
			public List<String> slice() {
				return Splitter.on(" ").splitToList("A B C D E F G H I J K L M N O P Q R S T U");
			}
		};
	}

	@Override
	public com.jiuxian.mossrose.job.DistributedJob.Executor<String> executor() {
		return new Executor<String>() {

			@Override
			public void execute(String item) {
				try {
					Thread.sleep(RandomUtils.nextInt(1, 5) * 1000);
				} catch (InterruptedException e) {
				}
				LOGGER.info("DistributedJob: {}", businessBean.echo(item));
			}
		};
	}

}
