package com.example.queue;

/**
 * @author 13781
 * @version 1.0
 * @created 23-9��-2018 12:42:11
 */
public interface CustomJob {

	void execute(CustomJobDetail jobDetail);

}