package com.example.diceroller

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    private val tag = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(tag, "onCreate")
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }

    // Lifecycle
    override fun onStart() { super.onStart(); Log.d(tag, "onStart") }
    override fun onResume() { super.onResume(); Log.d(tag, "onResume") }
    override fun onPause() { super.onPause(); Log.d(tag, "onPause") }
    override fun onStop() { super.onStop(); Log.d(tag, "onStop") }
    override fun onRestart() { super.onRestart(); Log.d(tag, "onRestart") }
    override fun onDestroy() { super.onDestroy(); Log.d(tag, "onDestroy") }
}

@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}

@Composable
fun DiceWithButtonAndImage() {
    var result by remember { mutableIntStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "Dice"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Number: $result",
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { result = Random.nextInt(1, 7) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,   
                contentColor = Color.White    
            )
        ) {
            Text(text = "Roll")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        DiceRollerApp()
    }
}
