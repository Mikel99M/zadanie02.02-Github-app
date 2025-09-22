package com.githubapp.dto;

import org.springframework.http.HttpStatus;

public record ErrorUserResponseDto(HttpStatus status, String Message) {
}
