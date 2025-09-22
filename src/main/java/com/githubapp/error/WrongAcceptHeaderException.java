package com.githubapp.error;

public class WrongAcceptHeaderException extends RuntimeException {
    public WrongAcceptHeaderException(String message) {super(message);}
}
