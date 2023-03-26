package com.marcelo.buscadordecep.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.marcelo.buscadordecep.component.ButtonScreen
import com.marcelo.buscadordecep.component.InputText
import com.marcelo.buscadordecep.listener.ResponseApi
import com.marcelo.buscadordecep.model.Address
import com.marcelo.buscadordecep.ui.theme.Teal700
import com.marcelo.buscadordecep.ui.theme.WHITE
import com.marcelo.buscadordecep.viewmodel.GetCepViewModel


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun GetCepScreen(navHostController: NavController? = null) {
    val viewModel: GetCepViewModel = hiltViewModel()
    val context = LocalContext.current

    var inputCep by remember { mutableStateOf("") }
    var inputPatio by remember { mutableStateOf("") }
    var inputNeighborhood by remember { mutableStateOf("") }
    var inputCity by remember { mutableStateOf("") }
    var inputState by remember { mutableStateOf("") }


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Buscador de Cep",
                        fontSize = 18.sp,
                    )
                },
                contentColor = WHITE,
                backgroundColor = Teal700
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                InputText(
                    value = inputCep,
                    onValueChange = {
                        inputCep = it
                    },
                    label = "Cep",
                    modifier = Modifier
                        .width(200.dp)
                        .padding(top = 50.dp, end = 20.dp, bottom = 10.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number
                    ),
                    maxLines = 1
                )

                ButtonScreen(
                    onClick = {
                        viewModel.responseApi(inputCep, object : ResponseApi {
                            override fun onSuccess(model: Address) {
                                inputPatio = if(model.patio == "null" || model.patio.isNullOrEmpty()) "" else model.patio
                                inputCity = if(model.city == "null" || model.city.isNullOrEmpty())  "" else model.city
                                inputNeighborhood = if(model.neighborhood == "null" || model.neighborhood.isNullOrEmpty()) "" else model.neighborhood
                                inputState = if(model.state == "null" || model.state.isNullOrEmpty()) "" else model.state
                            }

                            override fun onFailure(error: String) {
                                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
                            }
                        })
                    },
                    textButton = "Buscar Cep",
                    modifier = Modifier
                        .padding(top = 60.dp, bottom = 10.dp)
                        .height(55.dp)
                        .fillMaxWidth()
                )
            }

            InputText(
                value = inputPatio,
                onValueChange = {
                    inputPatio = it
                },
                label = "Logradouro",
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )

            InputText(
                value = inputNeighborhood,
                onValueChange = {
                    inputNeighborhood = it
                },
                label = "Bairro",
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )

            InputText(
                value = inputCity,
                onValueChange = {
                    inputCity = it
                },
                label = "Cidade",
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )

            InputText(
                value = inputState,
                onValueChange = {
                    inputState = it
                },
                label = "Estado",
                maxLines = 1,
                modifier = Modifier.width(100.dp)
            )
        }
    }
}

@Composable
@Preview
fun GetCepScreenPreview() {
    GetCepScreen()
}