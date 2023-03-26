package com.marcelo.buscadordecep.component

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.marcelo.buscadordecep.ui.theme.Teal700
import com.marcelo.buscadordecep.ui.theme.WHITE

@Composable
fun ButtonScreen(
    onClick: () -> Unit = {},
    textButton: String,
    modifier: Modifier = Modifier
){
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Teal700
        ),
        modifier = modifier
    ){
        Text(
            text = textButton,
            fontSize = 18.sp,
            color = WHITE
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun ButtonPreview(){
    ButtonScreen(
        textButton = "Confirmar"
    )
}