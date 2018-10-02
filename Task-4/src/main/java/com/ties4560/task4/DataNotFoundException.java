package com.ties4560.task4;

/**
 * @author Jaro
 * @version 25.9.2018
 *
 */
public class DataNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -5555567240703065575L;

	public DataNotFoundException(String message) {
		super(message);
	}
}