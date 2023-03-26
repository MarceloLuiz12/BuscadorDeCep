package com.marcelo.buscadordecep.repository

import com.marcelo.buscadordecep.datasource.DataSource
import com.marcelo.buscadordecep.listener.ResponseApi
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository @Inject constructor(private val dataSource: DataSource){

    fun responseApi(cep: String, responseApi: ResponseApi){
        dataSource.responseApi(cep, responseApi)
    }
}