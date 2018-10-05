package in.mindbug.send_email_using_gmail_api;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.servlet.annotation.WebServlet;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		final VerticalLayout layout = new VerticalLayout();

		final TextField toField = new TextField();
		toField.setWidth("300px");
		toField.setCaption("Type destination email here:");

		Button button = new Button("Send test email using Gmail API");
		button.setDisableOnClick(true);
		button.addClickListener(event -> {
			// send email
			try {
				GmailService gmailService = new GmailServiceImpl(GoogleNetHttpTransport.newTrustedTransport());
				GmailCredentials gmailCredentials = new GmailCredentials("your-email@gmail.com",
						"349******************.apps.googleusercontent.com",
						"sIh**************D",
						"ya29.G********************************************************************************vSqkN",
						"1/Wti************************************************************");

				gmailService.setGmailCredentials(gmailCredentials);

				gmailService.sendMessage(toField.getValue(), "Gmail API Demo",
						"This is an email sent using Gmail API... at " + new Date());

			} catch (GeneralSecurityException | IOException | MessagingException e) {
				e.printStackTrace();
			}
			layout.addComponent(new Label("Email sent " + toField.getValue() + ", Gmail API works!"));
			button.setEnabled(true);
		});

		layout.addComponents(toField, button);

		setContent(layout);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	}
}
