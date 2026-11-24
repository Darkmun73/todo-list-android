package io.github.darkmun.todolist.ui.todolist

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.darkmun.todolist.ui.theme.TODOListTheme

@Composable
fun TodoListScreen(viewModel: TodoListViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    TodoListScreen(uiState)
}

@Composable
fun TodoListScreen(uiState: TodoListUiState) {

}

@Preview(
    name = "Light Mode",
    showBackground = true,
    showSystemUi = true
)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun TodoListScreenPreview() {
    TODOListTheme {
        TodoListScreen()
    }
}
