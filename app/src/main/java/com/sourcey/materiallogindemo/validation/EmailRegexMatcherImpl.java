package com.sourcey.materiallogindemo.validation;

import android.util.Patterns;

/**
 * Created by talat on 03-08-2016.
 */
public class EmailRegexMatcherImpl implements EmailRegexMatcher {
    @Override
    public boolean matches(String input) {
        return Patterns.EMAIL_ADDRESS.matcher(input).matches();
    }
}
