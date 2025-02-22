package com.example.fetchdataapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.lifecycle.ViewModelProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            // Using a custom factory to pass the repository into the ViewModel
            val viewModel: FetchViewModel = viewModel(
                factory = FetchViewModelFactory(FetchRepository())
            )
            FetchApp(viewModel)
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FetchApp(viewModel: FetchViewModel) {
    Scaffold(topBar = {

        TopAppBar(title = { Text("Fetch Items") })
    }) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            // Loop through each group by listId
            viewModel.groupedItems.value.forEach { (listId, items) ->
                item {
                    Text(
                        text = "List ID: $listId",
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }
                items(items) { item ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("ID: ${item.id}")
                            Text("Name: ${item.name}")
                        }
                    }
                }
            }
        }
    }
}