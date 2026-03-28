package com.example.api
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf


class ShowViewModel : ViewModel() {
    val shows = mutableStateOf<List<Show.ShowItem>>(emptyList())

    fun fetchShows() {
        viewModelScope.launch {
            try {
                shows.value = ApiClient.api.getShows()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
