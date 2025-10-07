package com.githubapp.infrastructure.controller.dto.githubAPI;

import lombok.Builder;

import java.util.List;

@Builder
public record FinalRepositoryResponse(Long id, String name, User owner, List<Branch> branches) {
}
