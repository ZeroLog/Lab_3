package com.example.lab_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab_3.ui.theme.Lab_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
var test = remember {
    mutableStateOf(0)
}
    var qtext = remember {
        mutableStateOf("jopa1")
    }
    var q1 = "jopa1"
    var q2 = "jopa2"
    var q3 = "jopa3"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {

        Row(
            verticalAlignment= Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = qtext.value, style= TextStyle(fontSize = 25.sp))
        }
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
            ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "True", style= TextStyle(fontSize = 25.sp))
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "False", style= TextStyle(fontSize = 25.sp))
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .offset(x = 96.dp, y = 10.dp)
        ) {
            Button(onClick = {
                test.value = (test.value + 1) % 3
                when(test.value) {
                    0 -> qtext.value = q1
                    1 -> qtext.value = q2
                    2 -> qtext.value = q3
                }
            }) {
                Text(text = "Next", style= TextStyle(fontSize = 25.sp))
            }

        }
    }
}
