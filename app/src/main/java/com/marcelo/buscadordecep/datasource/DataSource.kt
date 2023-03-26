package com.marcelo.buscadordecep.datasource

import com.marcelo.buscadordecep.api.ViaCep
import com.marcelo.buscadordecep.listener.ResponseApi
import com.marcelo.buscadordecep.model.Address
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class DataSource @Inject constructor() {

    private val retrofit: ViaCep = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://viacep.com.br/")
        .build()
        .create(ViaCep::class.java)

    fun responseApi(cep: String, responseApi: ResponseApi) {
        if (cep.isEmpty()) {
            responseApi.onFailure("O campo cep precisa ser preenchido!")
        } else {
            retrofit.getAddress(cep).enqueue(object : Callback<Address> {
                override fun onResponse(call: Call<Address>, response: Response<Address>) {
                    if (response.code() == 200) {
                        val model = Address(
                            patio = response.body()?.patio.toString(),
                            neighborhood = response.body()?.neighborhood.toString(),
                            city = response.body()?.city.toString(),
                            state = response.body()?.state.toString()
                        )
                        responseApi.onSuccess(model)
                    } else {
                        responseApi.onFailure("Cep inválido!")
                    }
                }
                override fun onFailure(call: Call<Address>, t: Throwable) {
                    responseApi.onFailure("Erro inesperado!")
                }
            })
        }

    }
}