package com.sourcey.materiallogindemo.validation;

import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Test Class for EmailValidator
 * http://bytes.babbel.com/en/articles/2016-05-20-tdd-in-android.html
 */
public class EmailValidatorTest {

    private EmailValidator emailValidator;

    @Before
    public void setup(){
        emailValidator = new EmailValidator();
    }

    @Test
    public void validate_shouldReturnNoErrorsForValidEmails(){
        String validEmail = "ali@gmail.com";
        Validator.VALIDATION_RESULT result = emailValidator.validate(validEmail);
        assertThat(result).isEqualTo(Validator.VALIDATION_RESULT.NO_ERROR);

    }
}
