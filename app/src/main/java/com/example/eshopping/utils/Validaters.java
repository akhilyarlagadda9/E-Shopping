package com.example.eshopping.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validaters {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String USERNAME_PATTERN = "^[A-Za-z0-9_ ]{3,15}$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private static final String PHONE_NUMBER_PATTERN = "\\d{10}";
    private static final String PWD_PATTERN = "\\A[a-zA-Z0-9_)($#%/*!@]{6,20}\\z";

    public Validaters() {

    }

    public static boolean emailValidate(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }



}
