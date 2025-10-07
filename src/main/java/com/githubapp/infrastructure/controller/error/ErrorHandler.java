package com.githubapp.infrastructure.controller.error;

import com.githubapp.infrastructure.controller.dto.githubAPI.ErrorUserResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Log4j2
public class ErrorHandler {

//    @ExceptionHandler(UserNotFoundException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ErrorUserResponseDto handleException(UserNotFoundException ex) {
//        log.warn("error while accesing user from github api");
//        return new ErrorUserResponseDto(HttpStatus.NOT_FOUND, ex.getMessage());
//    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public ResponseEntity<ErrorUserResponseDto> handleException(UserNotFoundException ex) {
        log.warn("error while accesing user from github api");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorUserResponseDto(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

//    @ExceptionHandler(WrongAcceptHeaderException.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
//    public ErrorUserResponseDto handleException(WrongAcceptHeaderException ex) {
//        log.warn("error caused by wrong accept header");
//        return new ErrorUserResponseDto(HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
//    }

    @ExceptionHandler(WrongAcceptHeaderException.class)
    @ResponseBody
    public ResponseEntity<ErrorUserResponseDto> handleException(WrongAcceptHeaderException ex) {
        log.warn("error caused by wrong accept header");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                .contentType(MediaType.APPLICATION_JSON)
                .body(new ErrorUserResponseDto(HttpStatus.NOT_ACCEPTABLE, ex.getMessage()));
    }

}
