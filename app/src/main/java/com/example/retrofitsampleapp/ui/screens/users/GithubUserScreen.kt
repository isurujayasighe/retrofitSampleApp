package com.example.retrofitsampleapp.ui.screens.users

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.retrofitsampleapp.repository.model.GithubUsers
import com.example.retrofitsampleapp.repository.remote.NetworkResult
import com.example.retrofitsampleapp.util.SnackbarHandler
import kotlinx.coroutines.launch

@Composable
fun GithubUserScreen(modifier: Modifier,snackbarHandler: SnackbarHandler) {
    GitHubUserScreenContent(githubUsersViewModel = hiltViewModel(),snackbarHandler)
}

@OptIn(ExperimentalComposeApi::class)
@Composable
private fun GitHubUserScreenContent(
    githubUsersViewModel: GithubUsersViewModel,
    snackbarHandler: SnackbarHandler
) {

    val users by githubUsersViewModel.uiState.collectAsState(initial = NetworkResult.Loading())
    val scope = rememberCoroutineScope()
    when (users) {
        is NetworkResult.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        }

        is NetworkResult.Success -> {
            if (users.data != null) {
                DataList(users = users.data!!)
            }
        }

        is NetworkResult.Error -> {
          Text(text = users.message!!)
        }
    }
}

@Composable
private fun DataList(users: List<GithubUsers>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(users) { user ->
            GitHubUserCard(user = user)
        }
    }
}


@Composable
private fun GitHubUserCard(user: GithubUsers) {
    Card (modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
        .clickable { true }) {
        Text(text = user.login)
    }
}