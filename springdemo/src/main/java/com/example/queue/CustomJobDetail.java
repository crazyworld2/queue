package com.example.queue;

/**
 * @author 13781
 * @version 1.0
 * @created 22-9��-2018 22:01:20
 */
public class CustomJobDetail {

	private String jobName;

	public CustomJobDetail(){

	}

	public void finalize() throws Throwable {

	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
}