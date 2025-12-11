package com.example.navhost_controller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.navhost_controller.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") { HomeScreen(navController) }
                    composable("llmNotes") { LLMNotesScreen(navController) }
                    composable("apiKeys") { ApiKeysScreen(navController) }
                    composable("projects") { ProjectsScreen(navController) }

                    // Ruta con parámetro dinámico
                    composable(
                        route = "note/{noteId}",
                        arguments = listOf(navArgument("noteId") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("noteId")
                        NoteDetailScreen(navController, id)
                    }
                }
            }
        }
    }
}
