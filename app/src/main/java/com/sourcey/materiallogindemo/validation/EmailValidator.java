package com.sourcey.materiallogindemo.validation;

import android.support.annotation.Nullable;

/**
 * Created by talat on 02-08-2016.
 */
public class EmailValidator implements Validator {

    EmailRegexMatcher emailPattern;
    public EmailValidator(EmailRegexMatcher emailPattern) {
        this.emailPattern = emailPattern;
    }

    @Override
    public VALIDATION_RESULT validate(@Nullable String input) {
        if(input == null || input.isEmpty()) return VALIDATION_RESULT.EMPTY_INPUT_FIELD;
        if(!emailPattern.matches(input)) return VALIDATION_RESULT.MALFORMED_INPUT;
        return VALIDATION_RESULT.NO_ERROR;
    }

}
