package com.learning.hellostate
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier=modifier.padding(16.dp)) {
        var count: Int by rememberSaveable {
            mutableStateOf(0)
        }

        if(count in 1..6 || count > 10) {
            var showTask by remember { mutableStateOf(true ) }

            if(showTask) {
                WellnessTaskItem(taskName = "Have you taken a walk?", onClose = { showTask = false })
            }
            Text(text = "You have had some nice $count glasses", modifier = modifier.padding(16.dp))
        }

        Row(Modifier.padding(top=8.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                count++
            },
                enabled=count<15) {
                Text(text = "Add one")
            }

            Button(onClick = {
                count = 0
            }) {
                Text("Clear water count")
            }

        }


    }

}