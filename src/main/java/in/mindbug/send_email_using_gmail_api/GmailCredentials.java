package in.mindbug.send_email_using_gmail_api;

public class GmailCredentials {
	private final String userEmail;
	private final String clientId;
	private final String clientSecret;
	private final String accessToken;
	private final String refreshToken;

	public GmailCredentials(String userEmail, String clientId, String clientSecret, String accessToken,
			String refreshToken) {
		super();
		this.userEmail = userEmail;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

}
