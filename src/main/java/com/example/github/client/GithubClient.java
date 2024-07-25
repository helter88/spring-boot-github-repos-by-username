package com.example.github.client;

import com.example.github.model.GithubRepo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value ="github", url="https://api.github.com")
public interface GithubClient {

    @GetMapping("users/{userName}/repos")
    List<GithubRepo> getAllRepos(@PathVariable String userName);
}
