package com.githubapp.infrastructure.controller.dto.githubAPI;

import java.util.List;

public record RepositoryResponse(Long id, String name, User owner, Boolean fork, List<Branch> branches) {
}
