package com.example.github.controller;

import com.example.github.model.GithubRepo;
import com.example.github.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GithubController {
    private final GithubService githubService;

    @GetMapping("/{userName}")
    public List<GithubRepo> getAllRepo (@PathVariable String userName) {
        return githubService.getAllRepoByUserName(userName);
    }
}
