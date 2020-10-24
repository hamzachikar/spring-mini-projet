package ensa.ma.miniprojet.entitie;

public class AuthenticationResponse {
	private final Account account;
	private final String jwt;
	public AuthenticationResponse(Account account,String jwt) {
		this.jwt=jwt;
		this.account=account;
	}
	public String getJwt() {
		return jwt;
	}
	public Account getAccount() {
		return account;
	}
	
}
