package com.example.queue.core;



import com.example.queue.WrapperJob;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * @author 13781
 * @version 1.0
 * @created 23-9��-2018 12:42:16
 */
public class QueueFactory {

	private  static BlockingQueue<WrapperJob> blockQueue=new LinkedBlockingQueue<WrapperJob>();

	public QueueFactory(){
	}

	public void finalize() throws Throwable {

	}
	public static BlockingQueue getSingleBlockQueue(){
		return blockQueue;
	}
}//end QueueFactory