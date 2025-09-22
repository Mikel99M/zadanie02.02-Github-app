package com.githubapp.error;

import com.githubapp.dto.ErrorUserResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Log4j2
public class ErrorHandler {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorUserResponseDto handleException(UserNotFoundException ex) {
        log.warn("error while accesing user from github api");
        return new ErrorUserResponseDto(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(WrongAcceptHeaderException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorUserResponseDto handleException(WrongAcceptHeaderException ex) {
        log.warn("error caused by wrong accept header");
        return new ErrorUserResponseDto(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
    }

}
