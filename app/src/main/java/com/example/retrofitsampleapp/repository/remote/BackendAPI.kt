package com.example.retrofitsampleapp.repository.remote

import com.example.retrofitsampleapp.repository.model.GithubUsers
import com.example.retrofitsampleapp.repository.model.user.GitHubUser
import retrofit2.Response
import retrofit2.http.GET

interface BackendAPI {

    @GET("/users")
    suspend fun getGithubUsers(): Response<List<GithubUsers>>

    @GET("/user")
    suspend fun getGitHubUser():Response<GitHubUser>
}