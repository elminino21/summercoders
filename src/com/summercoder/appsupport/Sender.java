package com.summercoder.appsupport;



import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import org.apache.commons.mail.EmailException;

public class Sender{
    
    
   

        
             final String username = "@gmail.com";  /**gmail account */
	     final String password = ""; //passwerd
      
    public  Sender( String  recipient, String body, String subject)
    {   
             
            

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recipient));
			message.setSubject(subject);
			message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
                     
			throw new RuntimeException(e);
                          
		}
        
    
    
    }


	
}
