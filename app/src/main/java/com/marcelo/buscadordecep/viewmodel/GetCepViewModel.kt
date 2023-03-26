package com.marcelo.buscadordecep.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcelo.buscadordecep.listener.ResponseApi
import com.marcelo.buscadordecep.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetCepViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun responseApi(cep: String, responseApi: ResponseApi){
        viewModelScope.launch {
            repository.responseApi(cep, responseApi)
        }
    }
}