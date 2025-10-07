package com.githubapp.infrastructure.controller.dto.Database;

import lombok.Builder;

@Builder
public record RepoDto(String name, String owner) {
}
