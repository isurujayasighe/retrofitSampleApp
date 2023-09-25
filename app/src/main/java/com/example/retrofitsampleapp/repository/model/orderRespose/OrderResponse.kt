package com.example.retrofitsampleapp.repository.model.orderRespose

data class OrderResponse(
    val statusCode: Int,
    val responseBody: ResponseBody
)

data class ResponseBody(
    val workOrders: List<WorkOrder>
)

data class WorkOrder(
    val workOrderNumber: String,
    val workOrderSite: String,
    val faultDescription: String,
    val functionalObjectDescription: String,
    val plannedStartDate: String,
    val priority: String,
    val executedBy: String,
    val ifsWorkOrderStatus: String,
    val mobileWorkOrderStatus: String,
    val workType: String,
    val directive: String,
    val date: String,
    val opsFollowWoStatus: String,
    val outOfService: String,
    val workDetailLength: Int?, // You can specify a more specific type if needed
    val customerDetails: CustomerDetails
)

data class CustomerDetails(
    val customerNo: String?, // You can specify a more specific type if needed
    val contactName: String,
    val customerName: String,
    val phoneNo: String,
    val email: String
)
