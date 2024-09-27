package com.example.ejercicio_corte2_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable()
fun PantallaC(navController: NavHostController) {
    var expandir by remember { mutableStateOf(false) }
    val opciones = listOf("Kotlin", "Java", "JavaScript", "MySQL", "C++")
    var seleccionActual by remember { mutableStateOf("Selecciona un lenguaje") }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            // Dropdown menu
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expandir = !expandir }
                    .background(Color.Cyan, RoundedCornerShape(5.dp))
                    .padding(12.dp)
            ) {
                Text(
                    text = seleccionActual,
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
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(
                text = "JavaScript"
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(
                text = "JavaScript (JS) es un lenguaje de programación " +
                        "ligero, interpretado, o compilado justo-a-tiempo (just-in-time) " +
                        "con funciones de primera clase. Si bien es más conocido como un lenguaje " +
                        "de scripting (secuencias de comandos) para páginas web, y es usado en " +
                        "muchos entornos fuera del navegador, tal como Node.js, Apache CouchDB " +
                        "y Adobe Acrobat JavaScript es un lenguaje de programación basada " +
                        "en prototipos, multiparadigma, de un solo hilo, dinámico, con " +
                        "soporte para programación orientada a objetos, imperativa y declarativa."
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(
                text = "Logo"
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Image(
                painter = painterResource(id = R.drawable.javascript),
                contentDescription = "Logo de JavaScript",
                modifier = Modifier.padding(16.dp)
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(
                text = "Ejemplo de código"
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Image(
                painter = painterResource(id = R.drawable.javascriptcod),
                contentDescription = "Ejemplo de código JavaScript",
                modifier = Modifier.padding(16.dp)
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Button(onClick = {
                navController.navigate("Inicio") {
                    popUpTo(navController.graph.startDestinationId) { inclusive = true }
                }
            }) {
                Text(text = "Volver")
            }

        }
    }
}
