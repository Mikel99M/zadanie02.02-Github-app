package com.githubapp;

import com.githubapp.dto.FinalRepositoryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
@RequestMapping(value = "api")
public class GithubController {

    private final MyGithubService service;

    @GetMapping("/users/{userName}/repos")
    public ResponseEntity<List<FinalRepositoryResponse>> fetchAllRepos(
            @PathVariable("userName") String userName) {
        return ResponseEntity.ok(service.fetchAllRepositoriesNotForks(userName));
    }
}
