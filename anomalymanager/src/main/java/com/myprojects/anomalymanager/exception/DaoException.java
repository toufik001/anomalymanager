package com.myprojects.anomalymanager.exception;

/**
 * 
 * @author Baz Taoufik
 *
 */

public class DaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoException() {
	}
	
	public DaoException(String msg) {
		super(msg);
	}
	
	public DaoException(String msg, Throwable e) {
		super(msg, e);
	}
}
