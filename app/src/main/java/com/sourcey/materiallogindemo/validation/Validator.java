package com.sourcey.materiallogindemo.validation;

import android.support.annotation.Nullable;

/**
 * Created by talat on 02-08-2016.
 */
public interface Validator {

    enum VALIDATION_RESULT{
        /**
         * No error result.
         * */
        NO_ERROR
    }

    VALIDATION_RESULT validate (@Nullable String input);

}
