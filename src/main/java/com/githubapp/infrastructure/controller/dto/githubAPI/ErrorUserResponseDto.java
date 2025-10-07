package com.githubapp.infrastructure.controller.dto.githubAPI;

import org.springframework.http.HttpStatus;

public record ErrorUserResponseDto(HttpStatus status, String Message) {
}
