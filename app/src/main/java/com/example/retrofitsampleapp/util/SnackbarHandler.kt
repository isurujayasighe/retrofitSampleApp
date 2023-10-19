package com.example.retrofitsampleapp.util

import androidx.compose.material3.SnackbarHostState

class SnackbarHandler(private val snackbarHostState: SnackbarHostState) {
    suspend fun showSnackbar(msg: String){
        snackbarHostState.showSnackbar(msg)
    }
}