package com.githubapp.infrastructure.controller.error;

public class WrongAcceptHeaderException extends RuntimeException {
    public WrongAcceptHeaderException(String message) {super(message);}
}
