package com.example.scbtechxdemo.security;

public interface SecurityConstants {
	String SECRET_KEY = "scbdemoDevJWS";
	String TOKEN_PREFIX = "Bearer ";
	String HEADER_AUTHORIZATION = "Authorization";
	String CLAIMS_ROLE = "role";
	long EXPIRATION_TIME = ( 24 * 60 * 60 * 1000);
}
