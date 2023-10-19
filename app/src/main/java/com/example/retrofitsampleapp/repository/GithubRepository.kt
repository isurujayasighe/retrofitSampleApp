package com.example.retrofitsampleapp.repository

import com.example.retrofitsampleapp.repository.model.GithubUsers
import com.example.retrofitsampleapp.repository.model.user.GitHubUser
import com.example.retrofitsampleapp.repository.remote.BackendApiClient
import com.example.retrofitsampleapp.repository.remote.NetworkResult
import com.example.retrofitsampleapp.repository.remote.UIState
import com.example.retrofitsampleapp.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

interface GithubRepository {
   suspend fun getGithubUser():Flow<NetworkResult<GithubUsers>>
   suspend fun getGithubUserList(): Flow<NetworkResult<List<GithubUsers>>>
}