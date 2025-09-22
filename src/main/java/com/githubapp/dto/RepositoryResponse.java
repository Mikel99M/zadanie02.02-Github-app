package com.githubapp.dto;

import java.util.List;

public record RepositoryResponse(Long id, String name, User owner, Boolean fork, List<Branch> branches) {
}
