package com.marcelo.buscadordecep.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.marcelo.buscadordecep.ui.theme.Teal700
import kotlin.math.max

@Composable
fun InputText(
     value: String,
    onValueChange: (String) -> Unit = {},
    label: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
     maxLines: Int
){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange ,
        label = {
            Text(text = label)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Teal700,
            cursorColor = Teal700,
            focusedLabelColor = Teal700
        ),
        modifier = modifier,
        keyboardOptions = keyboardOptions,
        maxLines = 1
    )
}

@Preview(showBackground = true)
@Composable
private fun InputTextPreview(){
    InputText(
        value = "88352070",
        label = "teste",
        maxLines = 1
    )
}