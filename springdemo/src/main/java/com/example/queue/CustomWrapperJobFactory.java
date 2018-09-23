package com.example.queue;

/**
 * @author 13781
 * @version 1.0
 * @created 23-9��-2018 12:42:12
 */
public class CustomWrapperJobFactory extends CustomJobFactory {


	public CustomWrapperJobFactory(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	/**
	 * 
	 * @param bundle
	 */
	protected Object createJobInstance(CustomBundle bundle)throws InstantiationException,IllegalAccessException
	,ClassNotFoundException{
		return super.createJobInstance(bundle);
	}
}//end CustomWrapperJobFactory