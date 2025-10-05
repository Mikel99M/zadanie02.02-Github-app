package com.githubapp;

import com.githubapp.dto.Branch;
import com.githubapp.dto.FinalRepositoryResponse;
import com.githubapp.dto.RepositoryResponse;
import com.githubapp.dto.User;
import com.githubapp.error.UserNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class MyGithubService {

    private final GithubProxy proxy;

    public List<FinalRepositoryResponse> fetchAllNonForksRepositories(String user) {
        checkIfUserExists(user);

        List<RepositoryResponse> repos = proxy.getRepositories(user).stream()
                .filter(repo -> !repo.fork())
                .toList();

        List<FinalRepositoryResponse> finalRepos = new ArrayList<>();

        for (RepositoryResponse repo : repos) {
            List<Branch> branches = proxy.getBranches(repo.owner().login(), repo.name());
            FinalRepositoryResponse response = FinalRepositoryResponse.builder()
                    .id(repo.id())
                    .name(repo.name())
                    .owner(repo.owner())
                    .branches(branches)
                    .build();
            finalRepos.add(response);
        }

        return finalRepos;
    }

    private void checkIfUserExists(String user) {
        try {
            User response = proxy.getUserByUserName(user);
            if (response == null) {
                log.error("A user with name '%s' does not exist".formatted(user));
                throw new UserNotFoundException("No user with name '%s' found.".formatted(user));
            }
        } catch (FeignException.FeignClientException e) {
            log.error("THE ERROR IN SERVICE" + e.getMessage());
            throw new UserNotFoundException("No user with name '%s' found.".formatted(user));
        } catch (FeignException fe) {
            if (fe.status() == 403) {
                log.error("GitHub API rate limit exceeded");
                throw new RuntimeException("GitHub API rate limit exceeded");
            }
        }
    }

}
