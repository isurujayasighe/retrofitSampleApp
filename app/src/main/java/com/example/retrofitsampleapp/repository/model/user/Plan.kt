package com.example.retrofitsampleapp.repository.model.user


import com.google.gson.annotations.SerializedName

data class Plan(
    @SerializedName("collaborators")
    val collaborators: Int, // 0
    @SerializedName("name")
    val name: String, // free
    @SerializedName("private_repos")
    val privateRepos: Int, // 10000
    @SerializedName("space")
    val space: Int // 976562499
)