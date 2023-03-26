package com.marcelo.buscadordecep.api

import com.marcelo.buscadordecep.model.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViaCep {

    @GET("ws/{cep}/json/")
    fun getAddress(@Path("cep") cep: String) : Call<Address>
}