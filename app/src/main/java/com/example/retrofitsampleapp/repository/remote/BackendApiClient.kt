package com.example.retrofitsampleapp.repository.remote

import com.example.retrofitsampleapp.repository.model.GithubUsers
import com.example.retrofitsampleapp.repository.model.user.GitHubUser
import retrofit2.Response
import javax.inject.Inject

class BackendApiClient @Inject constructor(
    private val backendAPI: BackendAPI
) {

    suspend fun getGithubUsers(): Response<List<GithubUsers>> {
        return backendAPI.getGithubUsers()
    }

    suspend fun getGitHubUser():Response<GitHubUser>{
        return backendAPI.getGitHubUser()
    }
}