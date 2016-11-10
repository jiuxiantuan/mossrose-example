package com.jiuxian.jobs.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Splitter;
import com.jiuxian.jobs.bean.IBusinessBean;
import com.jiuxian.jobs.util.SpringContextHolder;
import com.jiuxian.mossrose.job.DistributedJob;

public class DistributedExampleJob implements DistributedJob<String> {

	private static final Logger LOGGER = LoggerFactory.getLogger(SimpleExampleJob.class);

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
				if ("D".equals(item)) {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				LOGGER.info("DistributedJob: {}", SpringContextHolder.getBean(IBusinessBean.class).echo(item));
			}
		};
	}

}
