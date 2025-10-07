package com.githubapp.infrastructure.controller;

import com.githubapp.domain.service.GitHubDatabaseService;
import com.githubapp.infrastructure.controller.dto.Database.RepoDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/repos")
public class GithubDatabaseContoller {

    private final GitHubDatabaseService service;

    @GetMapping
    public ResponseEntity<List<RepoDto>> getAllRepos(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(service.getAllRepos(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepoDto> getRepoById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getRepoById(id));
    }

    @PostMapping
    public ResponseEntity<RepoDto> createRepo(@RequestBody RepoDto dto) {
        return ResponseEntity.ok(service.createRepo(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRepo(@PathVariable Long id, @RequestBody RepoDto dto) {
        service.updateRepoById(id, dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRepo(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
