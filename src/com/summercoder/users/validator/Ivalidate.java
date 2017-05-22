package com.summercoder.users.validator;

public interface Ivalidate <T>
{
	/**
	 * return true if input is correctly/valid enter
	 * @param t
	 * @return
	 */
	boolean validInput(T t); 
	/**
	 * correct the input.
	 * if user enter 1/1/11
	 * or marz 1/11, etc. all will be the same.
	 * this corret input has to be implements on strings and numbers for name, dates, email,etc. validation
	 * @param t
	 * @return
	 */
	T correctInput(T t);
	
}
