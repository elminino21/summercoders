package com.summercoder.appsupport;

import java.io.File;

import javax.print.DocFlavor.URL;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;


public class Sender implements ISender{

	/**
	 * 
	 */
	public Sender()
	{
		
	}

	@Override
	public boolean send() throws EmailException {
		// Create the email message
		  HtmlEmail email = new HtmlEmail();
		  email.setHostName("mail.myserver.com");
		  email.addTo("jdoe@somewhere.org", "John Doe");
		  email.setFrom("me@apache.org", "Me");
		  email.setSubject("Test email with inline image");
		  
		  // embed the image and get the content id
		  File logo = new File("placeholder.JPG");
		  String cid = email.embed(logo, "Apt log");
		  
		  // set the html message
		  email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");

		  // set the alternative message
		  email.setTextMsg("Your email client does not support HTML messages");

		  // send the email
		  email.send();
		return false;
	}

	@Override
	public void getMassage(String massage) throws EmailException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTopic() {
		// TODO Auto-generated method stub
		
	}

	
	

	
}
