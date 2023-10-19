package com.example.retrofitsampleapp.repository.model.user


import com.google.gson.annotations.SerializedName

data class GitHubUser(
    @SerializedName("avatar_url")
    val avatarUrl: String, // https://avatars.githubusercontent.com/u/28628156?v=4
    @SerializedName("bio")
    val bio: String, // Android Developer 
    @SerializedName("blog")
    val blog: String,
    @SerializedName("collaborators")
    val collaborators: Int, // 0
    @SerializedName("company")
    val company: Any, // null
    @SerializedName("created_at")
    val createdAt: String, // 2017-05-11T14:12:02Z
    @SerializedName("disk_usage")
    val diskUsage: Int, // 6517
    @SerializedName("email")
    val email: Any, // null
    @SerializedName("events_url")
    val eventsUrl: String, // https://api.github.com/users/isurujayasighe/events{/privacy}
    @SerializedName("followers")
    val followers: Int, // 1
    @SerializedName("followers_url")
    val followersUrl: String, // https://api.github.com/users/isurujayasighe/followers
    @SerializedName("following")
    val following: Int, // 40
    @SerializedName("following_url")
    val followingUrl: String, // https://api.github.com/users/isurujayasighe/following{/other_user}
    @SerializedName("gists_url")
    val gistsUrl: String, // https://api.github.com/users/isurujayasighe/gists{/gist_id}
    @SerializedName("gravatar_id")
    val gravatarId: String,
    @SerializedName("hireable")
    val hireable: Boolean, // true
    @SerializedName("html_url")
    val htmlUrl: String, // https://github.com/isurujayasighe
    @SerializedName("id")
    val id: Int, // 28628156
    @SerializedName("location")
    val location: Any, // null
    @SerializedName("login")
    val login: String, // isurujayasighe
    @SerializedName("name")
    val name: String, // Isuru Jayasinghe
    @SerializedName("node_id")
    val nodeId: String, // MDQ6VXNlcjI4NjI4MTU2
    @SerializedName("organizations_url")
    val organizationsUrl: String, // https://api.github.com/users/isurujayasighe/orgs
    @SerializedName("owned_private_repos")
    val ownedPrivateRepos: Int, // 11
    @SerializedName("plan")
    val plan: Plan,
    @SerializedName("private_gists")
    val privateGists: Int, // 0
    @SerializedName("public_gists")
    val publicGists: Int, // 0
    @SerializedName("public_repos")
    val publicRepos: Int, // 15
    @SerializedName("received_events_url")
    val receivedEventsUrl: String, // https://api.github.com/users/isurujayasighe/received_events
    @SerializedName("repos_url")
    val reposUrl: String, // https://api.github.com/users/isurujayasighe/repos
    @SerializedName("site_admin")
    val siteAdmin: Boolean, // false
    @SerializedName("starred_url")
    val starredUrl: String, // https://api.github.com/users/isurujayasighe/starred{/owner}{/repo}
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String, // https://api.github.com/users/isurujayasighe/subscriptions
    @SerializedName("total_private_repos")
    val totalPrivateRepos: Int, // 12
    @SerializedName("twitter_username")
    val twitterUsername: Any, // null
    @SerializedName("two_factor_authentication")
    val twoFactorAuthentication: Boolean, // false
    @SerializedName("type")
    val type: String, // User
    @SerializedName("updated_at")
    val updatedAt: String, // 2023-07-13T10:17:37Z
    @SerializedName("url")
    val url: String // https://api.github.com/users/isurujayasighe
)