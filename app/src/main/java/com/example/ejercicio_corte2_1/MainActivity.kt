package com.example.ejercicio_corte2_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.ejercicio_corte2_1.ui.theme.Ejercicio_Corte2_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio_Corte2_1Theme {

                    principal()

            }
        }
    }
}
