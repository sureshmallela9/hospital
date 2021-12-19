package com.hospital.util;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurityUtils {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
    	int strength = 10;
    	SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength , sr);
        String encodedPassword = passwordEncoder.encode("smallela");
        System.out.println("encodedPassword : " + encodedPassword);
    }
}
