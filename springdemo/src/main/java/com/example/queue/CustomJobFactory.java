package com.example.queue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.StringUtils;

/**
 * @author 13781
 * @version 1.0
 * @created 22-9��-2018 21:25:07
 */
public class CustomJobFactory implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	public CustomJobFactory(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void setApplicationContext(ApplicationContext applicationContext){
		this.applicationContext=applicationContext;
	}

	/**
	 * 
	 * @param bundle
	 */
	protected Object createJobInstance(CustomBundle bundle)throws InstantiationException,IllegalAccessException
	,ClassNotFoundException{
		Object obj=null;
		if(bundle.getByteCLass()!=null){
			obj=bundle.getByteCLass().newInstance();
		}else if(!StringUtils.isEmpty(bundle.getPathClass())){
			obj=Class.forName(bundle.getPathClass()).newInstance();
		}else {
			throw new InstantiationException("未找到任务类");
		}
		return obj;
	}

	/**
	 * 
	 * @param customBundle
	 */
	public CustomJob newJob(Class<? extends CustomJob> clazz,CustomBundle customBundle)throws InstantiationException,IllegalAccessException
			,ClassNotFoundException{
		customBundle.setByteCLass(clazz);
		return newJob(customBundle);
	}

	public CustomJob newJob(CustomBundle customBundle)throws InstantiationException,IllegalAccessException
			,ClassNotFoundException{
		Object obj=this.createJobInstance(customBundle);
		this.applicationContext.getAutowireCapableBeanFactory().autowireBean(obj);
		return (CustomJob)obj;
	}

}//end CustomJobFactory