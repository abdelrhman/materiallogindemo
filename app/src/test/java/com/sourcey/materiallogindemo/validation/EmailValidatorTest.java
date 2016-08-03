package com.sourcey.materiallogindemo.validation;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;


/**
 * Test Class for EmailValidator
 * http://bytes.babbel.com/en/articles/2016-05-20-tdd-in-android.html
 */
public class EmailValidatorTest {

    private EmailValidator emailValidator;
    @Mock
    private EmailRegexMatcher regexMatcher;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        emailValidator = new EmailValidator(regexMatcher);
    }

    @Test
    public void validate_shouldReturnNoErrorsForValidEmails(){
        String validEmail = "ali@gmail.com";
        Validator.VALIDATION_RESULT result = emailValidator.validate(validEmail);
        assertThat(result).isEqualTo(Validator.VALIDATION_RESULT.NO_ERROR);
    }

    @Test
    public void validate_shouldReturnInputFieldEmptyErrorIfInputIsEmpty(){
        String emptyEmail = "";
        Validator.VALIDATION_RESULT result = emailValidator.validate(emptyEmail);
        assertThat(result).isEqualTo(Validator.VALIDATION_RESULT.EMPTY_INPUT_FIELD);
    }

    @Test
    public void validate_shouldReturnInputFieldEmptyErrorIfInputIsNull(){
        String emptyEmail = null;
        Validator.VALIDATION_RESULT result = emailValidator.validate(emptyEmail);
        assertThat(result).isEqualTo(Validator.VALIDATION_RESULT.EMPTY_INPUT_FIELD);
    }

    @Test
    public void validate_shouldReturnInvalidEmailForInvalidEmails(){
        when(regexMatcher.matches(anyString())).thenReturn(false);
        String emptyEmail = "invalid_email";
        Validator.VALIDATION_RESULT result = emailValidator.validate(emptyEmail);
        assertThat(result).isEqualTo(Validator.VALIDATION_RESULT.MALFORMED_INPUT);
    }


}
