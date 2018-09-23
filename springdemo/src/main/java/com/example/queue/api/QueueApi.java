package com.example.queue.api;

import com.example.queue.*;
import com.example.queue.core.QueueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 13781
 * @version 1.0
 * @created 23-9��-2018 12:42:15
 */
@Component
public class QueueApi {

	@Autowired
	private CustomWrapperJobFactory jobFactory;

	/**
	 * 
	 * @param byteClazz
	 * @param customJobDetail
	 */
	public void newJob(Class byteClazz, CustomJobDetail customJobDetail)throws InstantiationException,IllegalAccessException
			,ClassNotFoundException,InterruptedException{
		CustomBundle customBundle=new CustomBundle(customJobDetail);
		customBundle.setByteCLass(byteClazz);
		CustomJob customJob=jobFactory.newJob(customBundle);
		WrapperJob wrapperJob=new WrapperJob(customJob);
		wrapperJob.setJobDetail(customJobDetail);
		QueueFactory.getSingleBlockQueue().put(wrapperJob);
	}
}//end QueueApi