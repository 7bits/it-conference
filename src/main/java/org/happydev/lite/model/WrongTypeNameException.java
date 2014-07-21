package org.happydev.lite.model;

/**
 * For the cases when role doesn't exist
 */
public class WrongTypeNameException extends Exception {

    public WrongTypeNameException() {
        super();
    }

    public WrongTypeNameException(final String message) {
        super(message);
    }

    public WrongTypeNameException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
