package com.example.queue;

/**
 * @author 13781
 * @version 1.0
 * @created 23-9��-2018 12:42:17
 */
public class WrapperJob implements Runnable{

	private CustomJobDetail jobDetail;
	private  CustomJob customJob;

	public WrapperJob(CustomJob customJob){
		this.customJob=customJob;
	}

	public void run() {
		if(customJob!=null){
			customJob.execute(jobDetail);
		}
	}

	public void setJobDetail(CustomJobDetail jobDetail) {
		this.jobDetail = jobDetail;
	}
}