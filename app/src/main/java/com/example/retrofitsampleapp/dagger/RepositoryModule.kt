package com.example.retrofitsampleapp.dagger

import com.example.retrofitsampleapp.repository.GithubRepository
import com.example.retrofitsampleapp.repository.GithubRepositoryImpl
import com.example.retrofitsampleapp.repository.remote.BackendApiClient
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun getGitHubRepository(backendApiClient: BackendApiClient) = GithubRepositoryImpl(backendApiClient)

}

@InstallIn(SingletonComponent::class)
@Module
interface Repos {
    @Binds
    fun binds(githubRepositoryImpl: GithubRepositoryImpl): GithubRepository
}