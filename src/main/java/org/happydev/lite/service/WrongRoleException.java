package org.happydev.lite.service;

/**
 * For the cases when role doesn't exist
 */
public class WrongRoleException extends Exception {

    public WrongRoleException() {
        super();
    }

    public WrongRoleException(final String message) {
        super(message);
    }

    public WrongRoleException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
