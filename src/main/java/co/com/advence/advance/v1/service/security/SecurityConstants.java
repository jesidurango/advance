package co.com.advence.advance.v1.service.security;

public class SecurityConstants {
	
	private SecurityConstants() {}

	public static final String SECRET = "eyJhbGciOiJub25lIiwidHlwIjoiSldUIn0.eyJpc3MiOiJodHRwczovL2p3dC1p";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/v1/user/sign-up";
}
