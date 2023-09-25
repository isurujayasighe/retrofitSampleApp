package com.example.retrofitsampleapp.repository

import android.util.Log
import com.example.retrofitsampleapp.repository.model.orderRespose.OrderResponse
import com.example.retrofitsampleapp.repository.model.orderRespose.WorkOrder
import com.example.retrofitsampleapp.repository.remote.BackendApiClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class OrderRepository @Inject constructor(
    private val backendApiClient: BackendApiClient
) {
    fun getWorkOrders (): Flow<List<WorkOrder>> = flow {
        try {
            val response = backendApiClient.workOrders()
            if (response.isSuccessful){
                response.body()?.responseBody?.let { emit(it.workOrders) }
            }
        } catch (e: Exception){
            Log.e("WORK-ERROR",e.localizedMessage)
        }
    }
}