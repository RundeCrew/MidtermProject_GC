package midterm;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
     	
public class EmailClient {
	
	public EmailClient() {
		
	}
	
	public void sendEmail(String recipient, String body) {
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
				
		Session session = Session.getInstance(props, new Authenticator() {
		    @Override
		    protected PasswordAuthentication getPasswordAuthentication() {
		    	String username = "svkpartystore.sales@gmail.com";
		    	String password = "KrisStan12.3";
		        return new PasswordAuthentication(username, password);
		    }
		});
		
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress("svkpartystore.sales@gmail.com"));
			message.setRecipients(
			Message.RecipientType.TO, InternetAddress.parse(recipient));
			message.setSubject("Your e-mail receipt from SVK Party Store");
			 
			String msg = body;
			 
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");
			 
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			 
			message.setContent(multipart);
			 
			Transport.send(message);
			System.out.print("You receipt has ben sent.\n\n");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
