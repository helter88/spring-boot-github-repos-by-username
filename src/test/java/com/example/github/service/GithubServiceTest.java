package com.example.github.service;

import com.example.github.client.GithubClient;
import com.example.github.exception.UserNotFoundException;
import com.example.github.model.GithubRepo;
import com.example.github.model.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GithubServiceTest {
    @Mock
    private GithubClient githubClient;

    @InjectMocks
    private GithubService githubService;

    @Test
    @DisplayName("Return list of repos when user exist")
    void test1() {
        //given
        String userName = "testUser";
        List<GithubRepo> expectedRepos = List.of(
                new GithubRepo("repo1", new Owner("testUser"), false),
                new GithubRepo("repo2", new Owner("testUser"), false)
        );
        when(githubClient.getAllRepos(userName)).thenReturn(expectedRepos);

        //when
        List<GithubRepo> actualRepos = githubService.getAllRepoByUserName(userName);

        //then
        assertEquals(expectedRepos, actualRepos);
        verify(githubClient).getAllRepos(userName);
    }

    @Test
    @DisplayName("Throw exception when user doesn't exist")
    void test2() {
        //given
        String userName = "notExistingUser";
        when(githubService.getAllRepoByUserName(userName))
                .thenThrow(new UserNotFoundException("Couldn't find user: " + userName));

        //when & then
        assertThrows(UserNotFoundException.class, () -> githubService.getAllRepoByUserName(userName));
        verify(githubClient).getAllRepos(userName);
    }
}