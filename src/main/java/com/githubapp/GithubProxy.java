package com.githubapp;

import com.githubapp.dto.Branch;
import com.githubapp.dto.RepositoryResponse;
import com.githubapp.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "github-client", url = "https://api.github.com")
public interface GithubProxy {

    @GetMapping("/users/{user}")
    public User getUserByUserName(@PathVariable("user") String user);

    @GetMapping(value = "/users/{user}/repos", headers = "Accept=application/json")
    public List<RepositoryResponse> getRepositories(@PathVariable("user") String user);

    @GetMapping("/repos/{user}/{repo}/branches")
    public List<Branch> getBranches(@PathVariable("user") String user, @PathVariable("repo") String repo);
}
