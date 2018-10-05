package in.mindbug.send_email_using_gmail_api;

import java.io.IOException;

import javax.mail.MessagingException;

public interface GmailService {
	void setGmailCredentials(GmailCredentials gmailCredentials);
	boolean sendMessage(String recipientAddress, String subject, String body) throws MessagingException, IOException;
}
