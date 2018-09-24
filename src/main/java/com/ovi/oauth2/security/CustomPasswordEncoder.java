package com.ovi.oauth2.security;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence arg0) {
		// TODO Auto-generated method stub
		return (String) arg0;
	}

	@Override
	public boolean matches(CharSequence arg0, String arg1) {
		return arg0.equals(arg1);
	}

}
