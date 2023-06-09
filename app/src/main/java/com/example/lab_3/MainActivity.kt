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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.tooling.preview.Preview
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

Row(modifier = Modifier
    .background(Color.Cyan).fillMaxWidth(1f).fillMaxHeight(0.7f)) {

    Row(
        modifier = Modifier
            .background(Color.Red),

    ) {

        Text(text = "Question")
    }

    Column(
        modifier = Modifier
            .background(Color.Cyan),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.End
    ) {


        Text(text = "False")
    }
    Column(modifier = Modifier
        .background(Color.Cyan),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.End) {
        Text(text = "True")
        Text(text = "Next")
    }

}
}
