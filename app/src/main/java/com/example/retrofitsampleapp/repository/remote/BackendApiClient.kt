package com.example.retrofitsampleapp.repository.remote

import com.example.retrofitsampleapp.repository.model.orderRespose.OrderResponse
import retrofit2.Response
import javax.inject.Inject

class BackendApiClient @Inject constructor(
    private val backendAPI: BackendAPI
) {
    suspend fun workOrders(): Response<OrderResponse>{
        return backendAPI.workOrders()
    }
}