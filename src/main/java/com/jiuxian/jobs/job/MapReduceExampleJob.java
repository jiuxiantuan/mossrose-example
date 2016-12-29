package com.jiuxian.jobs.job;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.jiuxian.mossrose.job.MapReduceJob;

public class MapReduceExampleJob implements MapReduceJob<Integer, Integer> {

	private static final Logger LOGGER = LoggerFactory.getLogger(MapReduceExampleJob.class);

	@Override
	public com.jiuxian.mossrose.job.MapReduceJob.Mapper<Integer> mapper() {
		return new Mapper<Integer>() {

			@Override
			public List<Integer> map() {
				return Lists.newArrayList(1, 2, 3, 4, 5, 6, 7);
			}
		};
	}

	@Override
	public com.jiuxian.mossrose.job.MapReduceJob.Executor<Integer, Integer> executor() {
		return new Executor<Integer, Integer>() {

			@Override
			public Integer execute(Integer item) {
				return item * 2;
			}
		};
	}

	@Override
	public com.jiuxian.mossrose.job.MapReduceJob.Reducer<Integer> reducer() {
		return new Reducer<Integer>() {

			@Override
			public void reduce(List<Integer> rs) {
				LOGGER.info("Reduce result : {}", rs);
			}
		};
	}

}
