package com.example.fetchdataapp
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
class FetchViewModel(private val repository: FetchRepository) : ViewModel() {

    var groupedItems = mutableStateOf<Map<Int, List<FetchItem>>>(emptyMap())
        private set

    init {
        viewModelScope.launch {
            groupedItems.value = repository.getFilteredSortedItems()
        }
    }
}

// A ViewModel factory for easier instantiation in Compose
class FetchViewModelFactory(private val repository: FetchRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FetchViewModel(repository) as T
    }
}