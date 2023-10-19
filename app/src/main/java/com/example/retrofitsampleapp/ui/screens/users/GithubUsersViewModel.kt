package com.example.retrofitsampleapp.ui.screens.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitsampleapp.repository.GithubRepository
import com.example.retrofitsampleapp.repository.model.GithubUsers
import com.example.retrofitsampleapp.repository.model.user.GitHubUser
import com.example.retrofitsampleapp.repository.remote.NetworkResult
import com.example.retrofitsampleapp.repository.remote.UIState
import com.example.retrofitsampleapp.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GithubUsersViewModel @Inject constructor(
    private val githubRepository: GithubRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<NetworkResult<List<GithubUsers>>>(NetworkResult.Loading())
    val uiState: MutableStateFlow<NetworkResult<List<GithubUsers>>> = _uiState

    init {
        Timber.tag(Constants.LOG_D).d(GithubUsersViewModel::class.qualifiedName)
        getGitUserList()
    }

    private fun getGitUserList(){
        viewModelScope.launch {
            githubRepository.getGithubUserList().collect{ users ->
                _uiState.value = users
            }
        }
    }
}