package org.happydev.lite.web;

/**
 * For the cases when parameter doesn't match the type needed
 */
public class UrlParameterException extends Exception {

    public UrlParameterException() {
        super();
    }

    public UrlParameterException(final String message) {
        super(message);
    }

    public UrlParameterException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
