package com.learning.hellostate

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier




@Composable
fun WellnessTaskList(
    list: List<WellnessTask>,
    onCheckedChange: (WellnessTask, Boolean) -> Unit,
    onCloseTask : (task: WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(list, key = { task -> task.id }) { task ->
            WellnessTaskItem(taskName = task.label, task.checked,  onCheckedChange = { onCheckedChange(task, it) }, onClose={ onCloseTask(task) })
        }
    }
}