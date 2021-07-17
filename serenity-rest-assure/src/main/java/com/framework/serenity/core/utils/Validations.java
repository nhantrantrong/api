package com.framework.serenity.core.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Implementation of Validate common functions
 *
 * @author trantrongnhan
 */
public class Validations {
    /**
     * Validate if the actual integer is greater than the expected integer
     *
     * @param actual          the actual integer to check if greater than expected
     * @param expected        the expected integer to compare with the actual integer
     * @param messageIfFailed the message if the validation is failed
     */
    public void validateGreaterThan(int actual, int expected, String messageIfFailed) {
        assertThat(messageIfFailed, actual, greaterThan(expected));
    }

    /**
     * Validate if 2 objects are equal
     *
     * @param actual          the actual object to compare with the expected
     * @param expected        the expected object to compare with the actual
     * @param messageIfFailed the message if the validation is failed
     */
    public void validateEqual(Object actual, Object expected, String messageIfFailed) {
        assertThat(messageIfFailed, actual, equalTo(expected));
    }

    public void validateNull(Object actual, String messageIfFailed) {
        assertThat(messageIfFailed, actual, nullValue());
    }
}
