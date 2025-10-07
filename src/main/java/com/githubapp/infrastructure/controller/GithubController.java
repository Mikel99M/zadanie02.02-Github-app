package com.githubapp.infrastructure.controller;

import com.githubapp.domain.service.MyGithubService;
import com.githubapp.infrastructure.controller.dto.githubAPI.FinalRepositoryResponse;
import com.githubapp.infrastructure.controller.error.WrongAcceptHeaderException;
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
            @PathVariable("userName") String userName,
            @RequestHeader(value = "Accept", required = true) String Accept) {
        if (!"application/json".equals(Accept)) {
            throw new WrongAcceptHeaderException("Wrong accept header content type");
        }
        return ResponseEntity.ok(service.fetchAllNonForksRepositories(userName));
    }
}
