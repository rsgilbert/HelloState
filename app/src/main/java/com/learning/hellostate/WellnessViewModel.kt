package com.learning.hellostate

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewModel: ViewModel() {

    private val _tasks : SnapshotStateList<WellnessTask> = getWellnessTasks().toMutableStateList()
    val tasks : List<WellnessTask> get() = _tasks

    val remove = fun (item: WellnessTask) {
        _tasks.remove(item)
    }

    val changeTaskChecked = fun(item: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == item.id }?.let { task ->
            println("Updating checked to $checked")
            task.checked = checked
        }
    }

}

private fun getWellnessTasks() = List(30) { i ->
    WellnessTask(i, "Task # ${i+1}")
}