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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    var showTask by remember { mutableStateOf(true ) }


    var juiceCount by rememberSaveable {
        mutableStateOf(0)
    }
    var showJuiceTask by remember { mutableStateOf(true ) }

    Column {
        StatelessWaterCounter(count = count, onIncrement = { count++ } , onCountCleared = { count = 0 },
            showTask=showTask,
            onCloseTask = { showTask=false},
            modifier=modifier)
    }


}

@Composable
fun StatelessWaterCounter(count: Int, onIncrement: ()->Unit, onCountCleared: ()->Unit, showTask: Boolean, onCloseTask: ()->Unit, modifier: Modifier= Modifier) {
    Column(modifier=modifier.padding(16.dp)) {
           if(count in 1..6 || count > 10) {
            if(showTask) {
                WellnessTaskItem(taskName = "Have you taken a walk?", false, onCheckedChange = {}, onClose=onCloseTask)
            }
            Text(text = "You have had some nice $count glasses", modifier = modifier.padding(16.dp))
        }

        Row(Modifier.padding(top=8.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = {
                onIncrement()
            },
                enabled=count<15) {
                Text(text = "Add one")
            }

            Button(onClick = {
                onCountCleared()
            }) {
                Text("Clear water count")
            }

        }


    }

}