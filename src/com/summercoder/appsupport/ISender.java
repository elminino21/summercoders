package com.summercoder.appsupport;

import org.apache.commons.mail.EmailException;

/**
 * will handle comments and emailing support
 * @author Jose Gonzalez
 *
 */
public interface  ISender {
		
	boolean send(String  recipient, String body, String subject);
	
		
}
