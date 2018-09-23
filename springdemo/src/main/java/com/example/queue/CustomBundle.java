package com.example.queue;

/**
 * @author 13781
 * @version 1.0
 * @created 22-9��-2018 21:58:12
 */
public class CustomBundle {

	public CustomJobDetail jobDetail;
	private Class byteCLass;
	private String pathClass;

	public CustomBundle(CustomJobDetail jobDetail){
		this.jobDetail=jobDetail;
	}

	public void finalize() throws Throwable {

	}

	public Class getByteCLass() {
		return byteCLass;
	}

	public void setByteCLass(Class byteCLass) {
		this.byteCLass = byteCLass;
	}

	public String getPathClass() {
		return pathClass;
	}

	public void setPathClass(String pathClass) {
		this.pathClass = pathClass;
	}
}//end CustomBundle