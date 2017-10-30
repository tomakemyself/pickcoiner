package com.pickcoiner.common.exception;

/**
 * SMS对象空异常
 * @author Dicky Yin
 * @date 2017-10-27
 */
public class SMSNullException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SMSNullException() {
		super();
	}

	public SMSNullException(String s) {
		super("pickcoiner SMS 对象值Null异常"+s);
	}

	public SMSNullException(Throwable throwable) {
		super(throwable);
		
	}

	public SMSNullException(String s, Throwable throwable) {
		super("pickcoiner SMS 对象值Null异常"+s, throwable);
	}

}
