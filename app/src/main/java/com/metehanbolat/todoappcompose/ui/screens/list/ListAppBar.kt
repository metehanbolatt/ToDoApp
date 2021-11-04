package com.metehanbolat.todoappcompose.ui.screens.list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.metehanbolat.todoappcompose.ui.theme.topAppBarBackgroundColor
import com.metehanbolat.todoappcompose.ui.theme.topAppBarContentColor
import com.metehanbolat.todoappcompose.R
import com.metehanbolat.todoappcompose.data.models.Priority

@Composable
fun ListAppBar() {
    DefaultListAppBar(
        onSearchClicked = {

        }
    )
}

@Composable
fun DefaultListAppBar(
    onSearchClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = "Tasks",
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        actions = {
            ListAppBarActions(onSearchClicked = onSearchClicked)
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor
    )
}

@Composable
fun ListAppBarActions(
    onSearchClicked: () -> Unit
) {
    SearchAction(onSearchClicked = onSearchClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(onClick = onSearchClicked) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(id = R.string.search_action),
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}

@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
) {

}

@Preview
@Composable
fun DefaultListAppBarPreview() {
    DefaultListAppBar(
        onSearchClicked = {

        }
    )
}