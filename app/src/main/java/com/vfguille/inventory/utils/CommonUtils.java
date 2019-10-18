package com.vfguille.inventory.utils;

public class CommonUtils {
    private final static int MAX_LENGTH_PASSWORD = 12;
    private final static int MIN_LENGTH_PASSWORD = 8;
    private final static String REGEXP_PASSWORD1 = ".*([A-Z]){1,}.*";
    private final static String REGEXP_PASSWORD2 = ".*([0-9]){1,}.*";
    private final static String REGEXP_EMAIL = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Za-z]{2,6}$";

    public static boolean checkEqualsPasswords(String pass1, String pass2){
        return  pass1.equals(pass2);
    }

    public static boolean regexpPasswordsValidation(String pass1){
        return pass1.matches(REGEXP_PASSWORD1) && pass1.matches(REGEXP_PASSWORD2);
    }

    public static boolean checkPasswordLength(String pass1){
        return (pass1.length() >= MIN_LENGTH_PASSWORD && pass1.length() <= MAX_LENGTH_PASSWORD);
    }

    public static boolean regexpEmailValidation(String email){
        return email.matches(REGEXP_EMAIL);
    }
}
