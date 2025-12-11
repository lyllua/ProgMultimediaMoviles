package com.example.navhost_controller.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class Note(val id: Int, val title: String)

@Composable
fun LLMNotesScreen(navController: NavController) {
    // Datos definidos en la práctica [cite: 127-131]
    val llmNotesList = listOf(
        Note(1, "¿Qué es un LLM?"),
        Note(2, "Tokenización y embeddings"),
        Note(3, "Modelos generativos vs predictivos"),
        Note(4, "Prompt engineering básico")
    )

    Column(modifier = Modifier.padding(20.dp)) {
        Text("Apuntes sobre modelos LLM", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(20.dp))

        LazyColumn {
            items(llmNotesList) { note ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("note/${note.id}") // Navegación con parámetro
                        }
                ) {
                    Text(
                        text = note.title,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        Spacer(Modifier.height(20.dp))

        // Opción de volver al menú principal
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver al Menú")
        }
    }
}