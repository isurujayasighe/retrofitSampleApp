package com.example.retrofitsampleapp.repository.remote

import com.example.retrofitsampleapp.repository.model.orderRespose.OrderResponse
import retrofit2.Response
import retrofit2.http.GET

interface BackendAPI {

    @GET("/api/WorkOrder/OrderDetail")
    suspend fun workOrders():Response<OrderResponse>
}