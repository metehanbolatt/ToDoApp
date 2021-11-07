package com.metehanbolat.todoappcompose.ui.screens.list

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.metehanbolat.todoappcompose.data.models.Priority
import com.metehanbolat.todoappcompose.data.models.ToDoTask
import com.metehanbolat.todoappcompose.ui.theme.*
import com.metehanbolat.todoappcompose.util.RequestState

@ExperimentalMaterialApi
@Composable
fun ListContent(
    tasks: RequestState<List<ToDoTask>>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    if (tasks is RequestState.Success){
        if (tasks.data.isEmpty()){
            EmptyContent()
        }else{
            DisplayTasks(
                tasks = tasks.data,
                navigateToTaskScreen = navigateToTaskScreen
            )
        }
    }

}

@ExperimentalMaterialApi
@Composable
fun DisplayTasks(
    tasks: List<ToDoTask>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    LazyColumn{
        items(
            items = tasks,
            key = { task ->
                task.id
            }
        ){ task ->
            TaskItem(
                toDoTask = task,
                navigateToTaskScreen = navigateToTaskScreen
            )
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun TaskItem(
    toDoTask: ToDoTask,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.taskItemBackgroundColor,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,
        onClick = {
            navigateToTaskScreen(toDoTask.id)
        }
    ){
        Column(
            modifier = Modifier
                .padding(all = LARGE_PADDING)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    modifier = Modifier.weight(8f),
                    text = toDoTask.title,
                    color = MaterialTheme.colors.taskItemTextColor,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                    contentAlignment = Alignment.TopEnd,
                ){
                    Canvas(
                        modifier = Modifier
                            .width(PRIORITY_INDICATOR_SIZE)
                            .height(PRIORITY_INDICATOR_SIZE)
                    ){
                        drawCircle(
                            color = toDoTask.priority.color
                        )
                    }
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = toDoTask.description,
                color = MaterialTheme.colors.taskItemTextColor,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun TaskItemPreview() {
    TaskItem(
        toDoTask = ToDoTask(0, "Title", "Some random text", Priority.MEDIUM),
        navigateToTaskScreen = {}
    )
}