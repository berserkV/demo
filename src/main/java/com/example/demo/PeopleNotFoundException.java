package com.example.demo;

public class PeopleNotFoundException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public PeopleNotFoundException(String message) {
        super(message);
    }
}
