package com.tarrasques.straw.api.user.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
    //密码加密器
    private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //加密密码
    public static String encode(String password){
        return "{bcrypt}" + encoder.encode(password);
    }
}
