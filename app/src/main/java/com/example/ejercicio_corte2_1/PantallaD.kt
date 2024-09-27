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
fun PantallaD(navController: NavHostController) {
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
            // Menú desplegable
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
                text = "MySQL es el sistema de gestión de bases de datos relacional " +
                        "más extendido en la actualidad al estar basada en código abierto. " +
                        "Desarrollado originalmente por MySQL AB, fue adquirida por Sun " +
                        "MicroSystems en 2008 y esta su vez comprada por Oracle Corporation " +
                        "en 2010, la cual ya era dueña de un motor propio InnoDB para MySQL."
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
            Image(
                painter = painterResource(id = R.drawable.mysql),
                contentDescription = "Logo de MySQL",
                modifier = Modifier.padding(16.dp)
            )
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
        }

        item {
            Image(
                painter = painterResource(id = R.drawable.mysqlcod),
                contentDescription = "Ejemplo de código MySQL",
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
