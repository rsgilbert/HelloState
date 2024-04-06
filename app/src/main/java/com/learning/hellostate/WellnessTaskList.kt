package com.learning.hellostate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


fun getWellnessTasks() = List(30) { i ->
    WellnessTask(i, "Task # $i")
}


@Composable
fun WellnessTaskList(
    list: List<WellnessTask> = remember {
        getWellnessTasks()
    },
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(list) { task ->
            WellnessTaskItem(taskName = task.label)
        }
    }
}