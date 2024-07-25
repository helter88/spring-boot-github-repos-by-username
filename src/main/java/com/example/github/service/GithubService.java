package com.example.github.service;

import com.example.github.client.GithubClient;
import com.example.github.exception.UserNotFoundException;
import com.example.github.model.GithubRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GithubService {
    private final GithubClient githubClient;
    public List<GithubRepo> getAllRepoByUserName(String userName){
        try{
            return githubClient.getAllRepos(userName);
        } catch (RuntimeException exception){
            throw new UserNotFoundException("Couldn't find user: " + userName);
        }
    }
}
