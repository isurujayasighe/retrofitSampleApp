package com.example.retrofitsampleapp.repository.remote

import okhttp3.Authenticator
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class AuthenticationInterceptor: Interceptor, Authenticator {

    override fun intercept(chain: Interceptor.Chain): Response {

        val original: Request = chain.request()
        val builder: Request.Builder = original.newBuilder()
        val token: String? = "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"

        if (!token.isNullOrEmpty()) {
            builder.header("Authorization", "Bearer $token")
        }
        builder.header("Content-Type", "application/json")
        val request: Request = builder.build()

        return chain.proceed(request)
    }

    override fun authenticate(route: Route?, response: Response): Request? {
        TODO("Not yet implemented")
    }


}