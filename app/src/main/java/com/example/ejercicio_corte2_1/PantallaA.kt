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

@Composable
fun PantallaA(navController: NavHostController) {
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expandir = !expandir }
                    .background(Color.Cyan, RoundedCornerShape(5.dp))
                    .padding(12.dp)
            ) {
                Text(
                    text = seleccionActual,
                    modifier = Modifier.padding(8.dp)
                )
            }

            DropdownMenu(
                expanded = expandir,
                onDismissRequest = { expandir = false },
                modifier = Modifier
                    .fillMaxWidth()
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
            Text(
                text = "Kotlin"
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Text(
                text = "Kotlin es un lenguaje de programación de código abierto creado por JetBrains " +
                        "que se ha popularizado gracias a que se puede utilizar para programar " +
                        "aplicaciones Android.\n" +
                        "Este lenguaje es de tipado estático, ya que se puede desarrollar sobre JVM " +
                        "o JavaScript; o desde hace unos meses, incluso sin necesidad de ninguna de " +
                        "ellas, ya que paralelamente se está desarrollando en nativo con LLVM. Gracias " +
                        "a eso, es totalmente interoperable con código Java, lo que permite migrar de " +
                        "una forma gradual nuestros proyectos."
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
                painter = painterResource(id = R.drawable.kotlin),
                contentDescription = "Logo de Kotlin",
                modifier = Modifier.padding(16.dp)
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Image(
                painter = painterResource(id = R.drawable.kotlincod),
                contentDescription = "Logo de Kotlin",
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
