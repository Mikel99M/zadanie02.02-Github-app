package com.githubapp.domain.service;

import com.githubapp.domain.model.Repo;
import com.githubapp.domain.repository.RepoRepository;
import com.githubapp.infrastructure.controller.GitHubDatabaseMapper;
import com.githubapp.infrastructure.controller.dto.Database.RepoDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class GitHubDatabaseService {

    private final RepoRepository repository;
    private final GitHubDatabaseMapper mapper;

    public List<RepoDto> getAllRepos(Pageable pageable) {
        return mapper.mapRepoListToRepoDtoList(repository.findAll(pageable));
    }

    public RepoDto getRepoById(Long id) {
        Repo repo = repository.findById(id).orElseThrow(() -> new RuntimeException("No repo found "));
        return mapper.mapRepoToRepoDto(repo);
    }

    public RepoDto createRepo(RepoDto dto) {
        Repo repo = mapper.mapRepoDtoToRepo(dto);
        repository.save(repo);
        return dto;
    }

    public void updateRepoById(Long id, RepoDto dto) {
        Repo repo = mapper.mapRepoDtoToRepo(dto);
        repository.updateById(id, repo);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
