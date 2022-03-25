package com.test.myusersapp.error;

public class EmailRepeatedException extends Exception {
    public EmailRepeatedException(String msg) {
        super(msg);
    }
}
