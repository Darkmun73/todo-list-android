package io.github.darkmun.todolist.ui.todolist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.darkmun.todolist.ui.theme.TODOListTheme

@Composable
fun TodoListScreen(viewModel: TodoListViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    TodoListScreen(
        uiState = uiState,
        onSelectList = viewModel::selectList
    )
}

@Composable
fun TodoListScreen(
    uiState: TodoListUiState,
    onSelectList: (TodoListType) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 30.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TodoListType.entries.forEach { type ->
                    ElevatedFilterChip(
                        selected = uiState.selectedList == type,
                        onClick = { onSelectList(type) },
                        label = { Text(stringResource(type.getLabelResourceId())) }
                    )
                }
            }
        }
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TodoListScreenPreview() {
    TODOListTheme {
        TodoListScreen()
    }
}
