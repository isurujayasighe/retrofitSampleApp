package com.example.retrofitsampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofitsampleapp.ui.screens.takePictures.CamaraScreen
import com.example.retrofitsampleapp.ui.screens.users.GithubUserScreen
import com.example.retrofitsampleapp.ui.theme.RetrofitSampleAppTheme
import com.example.retrofitsampleapp.util.SnackbarHandler
import com.example.retrofitsampleapp.util.SnackbarHostComponent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitSampleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val snackbarHostState = remember { SnackbarHostState() }
                    val snackbarHandler = SnackbarHandler(snackbarHostState)

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        snackbarHost = { SnackbarHostComponent()}
                    ) { paddingValues ->
                        GithubUserScreen(modifier = Modifier.padding(paddingValues),snackbarHandler)
                    }
//                    DataScreen()
//                    CamaraScreen()
                }
            }
        }
    }
}

/*@Composable
fun DataScreen(viewModel: OrderViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val workOrders by viewModel.workOrderFlow.collectAsState(emptyList())
    LazyColumn(){
        items(workOrders){ workOrder ->
            Text(text = workOrder.workOrderNumber)
        }
    }
}*/

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RetrofitSampleAppTheme {
        Greeting("Android")
    }
}