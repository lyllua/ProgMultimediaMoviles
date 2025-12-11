package com.example.navhost_controller.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Notas AI", style = MaterialTheme.typography.headlineMedium)

        Button(
            onClick = { navController.navigate("llmNotes") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Apuntes sobre LLM")
        }

        Button(
            onClick = { navController.navigate("apiKeys") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Cómo usar API Keys")
        }

        Button(
            onClick = { navController.navigate("projects") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Proyectos con IA")
        }
    }
}