package com.bank.mvc.utils;

import javax.inject.Named;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Zalman on 06.05.2015.
 */

@Named
public class PasswordEncoder implements org.springframework.security.crypto.password.PasswordEncoder {

    private MessageDigest md;

    public PasswordEncoder() {
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String encode(CharSequence rawPassword) {
        if (md == null) {
            return rawPassword.toString();
        }

        md.update(rawPassword.toString().getBytes());

        byte byteData[] = md.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; ++i) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }

        return hexString.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        String encoded = encode(rawPassword);
        return encode(rawPassword).equals(encodedPassword);
    }
}
