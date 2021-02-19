package com.fastdevelop.web.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPassEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return String.valueOf(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        boolean result = String.valueOf(charSequence).equalsIgnoreCase(s);
        return result;
    }
}
