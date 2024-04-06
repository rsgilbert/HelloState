package com.learning.hellostate

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun WellnessScreen(modifier: Modifier = Modifier, wellnessViewModel: WellnessViewModel = viewModel()) {

    Column {
        WaterCounter(modifier)
        WellnessTaskList(
            wellnessViewModel.tasks,
            onCheckedChange = wellnessViewModel.changeTaskChecked,
            onCloseTask = wellnessViewModel.remove
        )
    }

}