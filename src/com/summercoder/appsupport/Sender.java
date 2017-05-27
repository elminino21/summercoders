package com.summercoder.appsupport;

import java.io.File;

import javax.print.DocFlavor.URL;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;


public class Sender implements ISender{

        private final String FromEmail = "joseaugusto978@gmail.com";
         private final String EmailSender = "Summer Coders";
         private String ToEmail = "";
         private String textmgn ;
	/**
	 * 
	 */
	public Sender()
	{
		
	}

	@Override
	public boolean send() throws EmailException {
		
		  HtmlEmail email = new HtmlEmail();
		  email.setHostName("smtp.googlemail.com");
		  email.addTo("00276523@student.necc.edu", "Jose Gonzalez");
		  email.setFrom("joseaugusto978@gmail.com", "summerdocers");
		  email.setSubject("Test email");
		  
		  // embed the image and get the content id
		  File logo = new File("file:APPFiles/images/newuser.png");
		  String cid = email.embed(logo, "Apt log");
		  
		  // set the html message
		  email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");

		  // set the alternative message
		  email.setTextMsg("Your email client does not support HTML messages");

		  // send the email
		  email.send();
		return true;
	}

	@Override
	public void getMassage(String massage) throws EmailException {
		this.textmgn  = "this is you reset mass";
		
	}

	@Override
	public void getEmail(String email) {
		this.ToEmail = "";
		
	}

	@Override
	public void getUser(int id) {
		
		
	}

	@Override
	public void getTopic() {
		// TODO Auto-generated method stub
		
	}

	
	

	
}
