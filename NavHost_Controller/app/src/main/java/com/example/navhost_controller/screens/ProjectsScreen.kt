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

@Composable
fun ProjectsScreen(navController: NavController) {
    val projectList = listOf(
        Note(10, "Chatbot de soporte técnico"),
        Note(11, "Análisis de sentimientos en redes"),
        Note(12, "Generación automática de resúmenes"),
        Note(13, "Aplicación de transcripción de audio")
    )

    Column(modifier = Modifier.padding(20.dp)) {
        Text("Proyectos que usan IA", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(20.dp))

        LazyColumn {
            items(projectList) { project ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("note/${project.id}")
                        }
                ) {
                    Text(
                        text = project.title,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        // Botón volver
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver")
        }
    }
}