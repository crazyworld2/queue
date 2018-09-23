package com.example.queue.consume;

import com.example.queue.WrapperJob;
import com.example.queue.core.QueueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 13781
 * @version 1.0
 * @created 23-9��-2018 12:42:14
 */
@Component
public class JobComsume extends Thread{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private static final int cousumeSum=3;
	private volatile boolean isPause;
	private ReentrantLock lock=new ReentrantLock();
	private Condition condition=lock.newCondition();
//	private ExecutorService service=Executors.newFixedThreadPool(cousumeSum);

	public JobComsume(){

	}

	@Override
	public void run(){
		while (true){
			lock.lock();
			try{
				while(isPause){
					condition.await();
				}
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				lock.unlock();
			}
			try{
				Thread.sleep(100);
				BlockingQueue<WrapperJob> blockingQueue=QueueFactory.getSingleBlockQueue();
				List<Runnable> list=new ArrayList<Runnable>();
				for (int i = 0; i <cousumeSum; i++) {
					list.add(blockingQueue.take());
				}
				ExecutorService service=Executors.newFixedThreadPool(cousumeSum);
				for (Runnable job:list ) {
					service.submit(job);
				}
				service.shutdown();
			}catch (java.lang.InterruptedException e){
				e.printStackTrace();
			}
		}

	}

	public void pauseJob(){
		lock.lock();
		try{
			isPause=true;
			log.info("消费线程将暂停。。。。。。。");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

	public void resumeJob(){
		lock.lock();
		try{
			isPause=false;
			condition.signalAll();
			log.info("消费线程将恢复运行。。。。。。。");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}

}//end JobComsume