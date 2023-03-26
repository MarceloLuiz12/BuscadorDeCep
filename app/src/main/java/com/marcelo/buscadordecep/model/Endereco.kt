package com.marcelo.buscadordecep.model

import com.google.gson.annotations.SerializedName

 class Address (
    @SerializedName("logradouro")
    val patio: String? = null,
    @SerializedName("bairro")
    val neighborhood: String? = null,
    @SerializedName("localidade")
    val city: String? = null,
    @SerializedName("uf")
    val state: String? = null
    )
