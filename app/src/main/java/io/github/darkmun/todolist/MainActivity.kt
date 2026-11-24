package io.github.darkmun.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import io.github.darkmun.todolist.ui.theme.TODOListTheme
import io.github.darkmun.todolist.ui.todolist.TodoListScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TODOListTheme {
                TodoListScreen()
            }
        }
    }
}