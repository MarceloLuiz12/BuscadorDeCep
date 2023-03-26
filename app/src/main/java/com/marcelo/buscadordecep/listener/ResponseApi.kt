package com.marcelo.buscadordecep.listener

import com.marcelo.buscadordecep.model.Address

interface ResponseApi {
    fun onSuccess(model: Address)
    fun onFailure(error: String)
}