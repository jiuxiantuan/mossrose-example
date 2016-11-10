package com.jiuxian.jobs.bean;

public class BusinessBean implements IBusinessBean {

	@Override
	public String echo(String value) {
		return "Capital " + value;
	}

}
