package com.example.ejercicio_corte2_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Inicio(navController: NavHostController) {
    var expandir by remember { mutableStateOf(false) }
    val opciones = listOf("Kotlin", "Java", "JavaScript", "MySQL", "C++")
    var seleccionActual by remember { mutableStateOf("Selecciona un lenguaje") }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(16.dp)
                .background(Color.White, RoundedCornerShape(5.dp))
                .padding(16.dp)
        ) {
            Text(
                text = "Lenguajes de Programación",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expandir = !expandir }
                    .background(Color.Cyan, RoundedCornerShape(5.dp))
                    .padding(12.dp)
            ) {
                Text(
                    text = seleccionActual,
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            DropdownMenu(
                expanded = expandir,
                onDismissRequest = { expandir = false },
                modifier = Modifier
                    .background(Color.White)
                    .padding(horizontal = 6.dp)
            ) {
                opciones.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) },
                        onClick = {
                            seleccionActual = opcion
                            expandir = false
                            when (opcion) {
                                "Kotlin" -> navController.navigate("PKotlin")
                                "Java" -> navController.navigate("PJava")
                                "JavaScript" -> navController.navigate("PJavaScript")
                                "MySQL" -> navController.navigate("PMySQL")
                                "C++" -> navController.navigate("PC++")
                            }
                        }
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.lenguages),
                contentDescription = "Logo de Kotlin",
                modifier = Modifier.padding(16.dp)
            )


        }
    }
}

@Composable
@Preview(showBackground = true)
fun principal() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Inicio") {
        composable("Inicio") {
            Inicio(navController)
        }
        composable("PKotlin") {
            PantallaA(navController)
        }
        composable("PJava") {
            PantallaB(navController)
        }
        composable("PJavaScript") {
            PantallaC(navController)
        }
        composable("PMySQL") {
            PantallaD(navController)
        }
        composable("PC++") {
            PantallaE(navController)
        }
    }
}
