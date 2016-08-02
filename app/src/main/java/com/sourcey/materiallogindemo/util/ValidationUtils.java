package com.sourcey.materiallogindemo.util;

/**
 * Created by talat on 29-07-2016.
 */
public class ValidationUtils {

    public  boolean isEmailValid(String email){
        return !(email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public  boolean isPasswordValid(String password){
        return !(password.isEmpty() || password.length() < 4 || password.length() > 10);
    }

}
