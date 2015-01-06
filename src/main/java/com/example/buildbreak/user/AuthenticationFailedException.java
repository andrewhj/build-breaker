package com.example.buildbreak.user;

/**
 * Created by ajohnson on 1/1/2015.
 */
public class AuthenticationFailedException extends Exception {
    public AuthenticationFailedException() {
    }

    public AuthenticationFailedException(String message) {
        super(message);
    }

    public AuthenticationFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationFailedException(Throwable cause) {
        super(cause);
    }
}
