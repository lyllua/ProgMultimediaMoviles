package com.example.navhost_controller.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NoteDetailScreen(navController: NavController, noteId: String?) {
    val text = when (noteId?.toIntOrNull()) {
        1 -> "Un LLM es un modelo entrenado con enormes cantidades de texto..."
        2 -> "Los embeddings son vectores que representan significado..."
        3 -> "Modelos generativos crean contenido; los predictivos predicen valores..."
        4 -> "El prompt engineering consiste en diseñar las instrucciones para el modelo..."

        else -> "Apunte no encontrado."
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Detalle del apunte", style = MaterialTheme.typography.headlineSmall)
        Text("ID del apunte: $noteId")
        Text(text)

        // Botón volver
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver")
        }
    }
}