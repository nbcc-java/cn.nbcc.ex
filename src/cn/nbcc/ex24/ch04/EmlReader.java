package cn.nbcc.ex24.ch04;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

public class EmlReader {
	
	 public static void display(File emlFile) throws Exception{
	        Properties props = System.getProperties();
//	        props.put("mail.host", "smtp.126.com");
	        props.put("mail.transport.protocol", "smtp");

	        Session mailSession = Session.getDefaultInstance(props, null);
	        InputStream source = new FileInputStream(emlFile);
	        MimeMessage message = new MimeMessage(mailSession, source);

	        Multipart part = (Multipart) message.getContent();
	        System.out.println("Subject : " + message.getSubject());
	        System.out.println("From : " + message.getSender());
	        System.out.println("--------------");
	        System.out.println("Body : " +  message.getContent());
	        
//	        MimeMessage message = 
	        		ByteArrayOutputStream os = new ByteArrayOutputStream();
	        		message.writeTo(os);
	        		String messageStr = os.toString();
	        		System.out.println(new String(os.toByteArray(),"UTF-8"));
	    }
	 
	 public   String   getMailContent(Part   part)   throws   Exception   {
         if (part.isMimeType("text/html")) {
			return new String(part.getContent().toString().getBytes(),"UTF-8");
		}
         return "";
	 }    

}
