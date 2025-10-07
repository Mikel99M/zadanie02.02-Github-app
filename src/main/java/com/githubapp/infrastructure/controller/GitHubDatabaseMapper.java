package com.githubapp.infrastructure.controller;

import com.githubapp.domain.model.Repo;
import com.githubapp.infrastructure.controller.dto.Database.RepoDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GitHubDatabaseMapper {

    public RepoDto mapRepoToRepoDto(Repo repo) {
        return RepoDto.builder()
                .name(repo.getName())
                .owner(repo.getOwner())
                .build();
    }

    public List<RepoDto> mapRepoListToRepoDtoList(List<Repo> repoList) {
        return repoList.stream()
                .map(this::mapRepoToRepoDto)
                .toList();
    }

    public Repo mapRepoDtoToRepo(RepoDto dto) {
        return Repo.builder()
                .owner(dto.owner())
                .name(dto.name())
                .build();
    }
}
