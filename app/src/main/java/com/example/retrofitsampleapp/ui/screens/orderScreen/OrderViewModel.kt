package com.example.retrofitsampleapp.ui.screens.orderScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitsampleapp.repository.OrderRepository
import com.example.retrofitsampleapp.repository.model.orderRespose.WorkOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderRepository: OrderRepository
):ViewModel() {

    val workOrderFlow: Flow<List<WorkOrder>> = orderRepository.getWorkOrders()

    init {
        getWorkOrders()
        Log.d("************","ViewModel")
    }

    private fun getWorkOrders(){
        viewModelScope.launch {
            orderRepository.getWorkOrders().collect { result ->
                Log.d("WORK_ORDER", result.toString())
            }
        }
    }

}