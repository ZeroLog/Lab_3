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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
    val test = rememberSaveable { mutableStateOf(0) }
    val table = rememberSaveable {
        mutableStateOf(
            listOf(
                mutableListOf<Any?>("Москва столица России?", "2+3=10?", "2+2=4?"), // Вопросы
                mutableListOf<Any?>(true, false, true), // правильный ответ
                mutableListOf<Any?>(null, null, null), // ответ пользователя
                mutableListOf<Any?>(null, null, null) // ответил ли пользователь на этот вопрос
            )
        )
    }
    val allTrue = table.value[3].all { it == true }
    val CellNull = table.value[3][test.value] as? Boolean ?: false
    var correctAnswers = rememberSaveable { mutableStateOf(0) } // Прав отв
    if (!allTrue){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = table.value[0][test.value].toString(), style = TextStyle(fontSize = 25.sp))
        }
        if (!CellNull) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(onClick = {
                    val updatedList = table.value.toMutableList()
                    updatedList[2][test.value] = true
                    updatedList[3][test.value] = true
                    table.value = updatedList
                    if (!allTrue) {
                        if (table.value[2][test.value] == table.value[1][test.value]) {
                            correctAnswers.value++
                        }
                    }

                }) {
                    Text(text = "True", style = TextStyle(fontSize = 25.sp))
                }
                Button(onClick = {
                    val updatedList = table.value.toMutableList()
                    updatedList[2][test.value] = false
                    updatedList[3][test.value] = true
                    table.value = updatedList
                    if (!allTrue) {
                        if (table.value[2][test.value] == table.value[1][test.value]) {
                            correctAnswers.value++
                        }
                    }
                }) {
                    Text(text = "False", style = TextStyle(fontSize = 25.sp))
                }
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
            }) {
                Text(text = "Next", style = TextStyle(fontSize = 25.sp))
            }
        }
    }
    }
    if (allTrue) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Количество правильных ответов: ${correctAnswers.value}", style = TextStyle(fontSize = 20.sp))
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(y = 200.dp)
        ) {
            Button(onClick = {
                val updatedList = table.value.toMutableList()
                updatedList[2] = mutableListOf(null, null, null)
                updatedList[3] = mutableListOf(null, null, null)
                table.value = updatedList
                correctAnswers.value = 0
            }) {
                Text(text = "Repeat", style = TextStyle(fontSize = 25.sp))
            }
        }
    }
}
