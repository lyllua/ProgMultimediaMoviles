package com.example.navhost_controller.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ApiKeysScreen(navController: NavController) { // Se añade NavController como parámetro
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text("Uso de API Keys", style = MaterialTheme.typography.headlineSmall)

        Text("""
            Una API Key es un identificador secreto que da acceso a un servicio.
            Buenas prácticas:
            ✔ Nunca subirlas a GitHub
            ✔ Usar variables de entorno
            ✔ Rotarlas periódicamente
            ✔ No incluirlas en el cliente
            
            Ejemplo de uso:
            val client = OpenAI(apiKey = "TU_API_KEY")
        """.trimIndent())

        Spacer(Modifier.height(20.dp))

        // Opción de volver al menú principal
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver")
        }
    }
}