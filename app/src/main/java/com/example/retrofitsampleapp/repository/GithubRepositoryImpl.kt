package com.example.retrofitsampleapp.repository

import com.example.retrofitsampleapp.repository.model.GithubUsers
import com.example.retrofitsampleapp.repository.model.user.GitHubUser
import com.example.retrofitsampleapp.repository.remote.BackendApiClient
import com.example.retrofitsampleapp.repository.remote.NetworkResult
import com.example.retrofitsampleapp.util.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val backendApiClient: BackendApiClient
) : GithubRepository {
    override suspend fun getGithubUser(): Flow<NetworkResult<GithubUsers>> {
        TODO("Not yet implemented")
    }

    override suspend fun getGithubUserList(): Flow<NetworkResult<List<GithubUsers>>> = flow {
        emit(NetworkResult.Loading())
        try {
            val response = backendApiClient.getGithubUsers()
            if (response.isSuccessful) {
                emit(NetworkResult.Success(response.body()!!))
            }else{
                emit(NetworkResult.Error(response.errorBody().toString()))
            }
        } catch (e: Exception) {
            emit(NetworkResult.Error(e.localizedMessage))
        } catch (e: HttpException) {
            emit(NetworkResult.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

}