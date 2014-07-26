package org.happydev.core.web.util;

import org.happydev.core.web.UrlParameterException;

/**
 * Utilities for parameters handling
 */
public class ControllerUtils {

    /**
     * Converts String parameter to Long value and checks the presence if needed
     * @param urlParameter a String parameter value
     * @param required <code>true</code> when parameter should be present and <code>false</code> otherwise
     * @return Long parameter value or null if String value was null and parameter isn't required
     * @throws UrlParameterException when String value isn't null but can't be converted to Long
     */
    public Long convertStringToLong(final String urlParameter, final boolean required) throws UrlParameterException {
        Long parameterValue = null;
        if (urlParameter == null) {
            if (required) {
                throw new UrlParameterException("Parameter should be present");
            }
        } else {
            try {
                parameterValue = Long.parseLong(urlParameter);
            } catch (NumberFormatException e) {
                throw new UrlParameterException("Wrong Long parameter", e);
            }
        }

        return parameterValue;
    }
}
