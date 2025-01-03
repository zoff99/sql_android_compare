package com.example.sqlcompareexampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.MutableStateFlow

val messages = MutableStateFlow("running tests ...")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JDBCExampleAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
        val result = example().testme(this)
        messages.value = messages.value + result
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val txt by messages.collectAsState()
    Text(
        text = "" + txt,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge.copy(fontSize = 11.sp, lineHeight = 12.sp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JDBCExampleAppTheme {
        Greeting()
    }
}