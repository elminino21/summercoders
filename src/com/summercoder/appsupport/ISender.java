package com.summercoder.appsupport;

import org.apache.commons.mail.EmailException;

/**
 * will handle comments and emailing support
 * @author Jose Gonzalez
 *
 */
public interface  ISender {
		
	boolean send() throws EmailException;
	void getMassage(String massage) throws EmailException;
	void getEmail(String email);
	void getUser(int id);
	void getTopic();
		
}
