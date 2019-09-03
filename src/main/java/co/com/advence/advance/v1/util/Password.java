package co.com.advence.advance.v1.util;

import java.security.SecureRandom;
import java.util.Random;

public class Password {

	private static final Random RANDOM = new SecureRandom();
	
	public static byte[] getNextSalt() {
		byte[] salt = new byte[32];
		RANDOM.nextBytes(salt);
		return salt;
	}

	public static void main(String[] args) {
		byte[] salt = getNextSalt();
		System.err.println(new String(salt));
		System.err.println(new String(salt).getBytes());
		System.err.println(salt);
		System.err.println(new String(salt));
		System.err.println(new String(new String(salt).getBytes()));
	}
	
}
