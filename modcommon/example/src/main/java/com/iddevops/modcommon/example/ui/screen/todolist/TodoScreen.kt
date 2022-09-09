package com.iddevops.modcommon.example.ui.screen.todolist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.iddevops.core.main.util.request.Default
import com.iddevops.core.main.util.request.Failed
import com.iddevops.core.main.util.request.Loading
import com.iddevops.core.main.util.request.Success
import com.iddevops.core.main.util.toDp
import com.iddevops.core.ui.ui.component.button.StadiumButton
import com.iddevops.core.ui.ui.component.text.TextRegularStandard
import com.iddevops.core.ui.util.ButtonState
import com.iddevops.modcommon.example.domain.model.Todo
import com.iddevops.modcommon.example.domain.payload.TodoPayload
import com.iddevops.modcommon.example.ui.viewmodel.TodoViewModel
import org.koin.androidx.compose.viewModel

@Composable
fun TodoScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier)
    ) {
        Content()
        DownloadButton()
    }
}

@Composable
private fun ColumnScope.Content() {
    val vm: TodoViewModel by viewModel()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
    ) {

        when (val state = vm.todoListState.collectAsState().value) {
            is Default -> {
                TextContent(content = "Iddle")
            }

            is Failed -> {
                TextContent(content = "Failed: ${state.e.message}")
            }

            is Loading -> {
                ProgressBlocker()
            }

            is Success -> {
                ListContent(list = state.value)
            }
        }

    }
}

@Composable
private fun BoxScope.ListContent(
    list: List<Todo>
) {
    LazyColumn(
        modifier = Modifier
            .align(Alignment.Center),
    ) {
        list.map {
            item(it.id) {
                ListItem(item = it)
            }
        }
        item {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.toDp)
            )
        }
    }
}


@Composable
private fun ListItem(item: Todo) {
    Card(
        shape = RoundedCornerShape(8.toDp),
        modifier = Modifier.padding(16.toDp, 16.toDp, 16.toDp, 0.toDp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .padding(8.toDp)
                .height(50.toDp)
        ) {
            TextRegularStandard(
                modifier = Modifier.align(Alignment.Center),
                text = "${item.title}",
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun BoxScope.ProgressBlocker() {
    CircularProgressIndicator(
        modifier = Modifier
            .align(Alignment.Center),
    )
}

@Composable
private fun BoxScope.TextContent(content: String?) {
    TextRegularStandard(
        modifier = Modifier
            .align(Alignment.Center),
        text = "$content"
    )
}

@Composable
fun DownloadButton() {
    val vm: TodoViewModel by viewModel()
    val context = LocalContext.current.applicationContext
    Box(modifier = Modifier.padding(16.toDp)) {
        StadiumButton(
            label = "Download",
            state = when (vm.todoListState.collectAsState().value) {
                is Loading -> ButtonState.LOADING
                else -> ButtonState.NORMAL
            },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            vm.todoListState.request(payload = TodoPayload())
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun Preview() {
    TodoScreen()
}

@Composable
@Preview(showSystemUi = false)
fun ListPreview() {
    Box {
        ListContent(list = Todo.MOCK_LIST)
    }
}