package com.example.module2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module2.ui.theme.Module2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2Theme {
                Hello(Modifier, "Kotlin")
            }
        }
    }
}

@Composable
fun Hello(modifier: Modifier = Modifier, name: String? = null) {
    Module2Theme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name ?: "Имя не задано",
                fontSize = 20.sp,
                modifier = modifier
            )
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(
            text = "Hello $name!",
            modifier = modifier,
        )
    }
}
@Preview(
    name = "round",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=200dp,height=200dp,isRound=true",
    backgroundColor = 0xFFFFE500
)
@Preview(
    name = "landscape",
    showBackground = true,
    showSystemUi = true,
    device = "spec:parent=pixel_8,orientation=landscape"
)
@Preview(
    name = "portrait",
    showBackground = true,
    showSystemUi = true,
    device = "spec:parent=pixel_8,orientation=portrait"
)
@Composable
fun HelloPreview() {
    Module2Theme {
        Hello(Modifier,"Android")
    }
}

@Preview(name = "Task 3_1", showBackground = true, showSystemUi = true, group = "Task 3")
@Composable
fun Task3_1(modifier: Modifier = Modifier,
            name: String? = stringResource(R.string.jetpack_compose_definition)) {
    Module2Theme {
        Text(
            text = name ?: "Имя не задано",
            fontSize = 20.sp,
            modifier = modifier,
            textAlign = TextAlign.Center,
            color = Color.Green,
            fontStyle = FontStyle.Italic
        )

    }
}

@Preview(name = "Task 3_2", showBackground = true, showSystemUi = true, group = "Task 3")
@Composable
fun Task3_2(modifier: Modifier = Modifier,
            name: String? = stringResource(R.string.jetpack_compose_definition)){
    Module2Theme {
        Text(
            text = name ?: "Имя не задано",
            fontSize = 20.sp,
            modifier = modifier,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(name = "Task 3_3", showBackground = true, showSystemUi = true, group = "Task 3")
@Composable
fun Task3_3(modifier: Modifier = Modifier,
            name: String? = stringResource(R.string.jetpack_compose_definition)){
    Module2Theme {

        Text(
            text = name ?: "Имя не задано",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = modifier.padding(top = 48.dp),
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview (name = "Task 4", showBackground = true, showSystemUi = true, group = "Task 4")
@Composable fun Task4(){
    Module2Theme {
        Scaffold(
            topBar = {TopAppBar(
                title = {
                    Text(text = "FirstComposeProject",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF6200EE))
            )
            },
            content = { innerPadding ->
                Column(modifier = Modifier.padding(innerPadding)) {
                    Button(
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(2.dp, Color.Gray),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.LightGray,
                            contentColor = Color.Black
                        ),
                        modifier = Modifier.fillMaxWidth()
                        .padding(horizontal = 0.dp, vertical = 4.dp),
                        onClick = {}) { Text(text = "Нажми на меня", fontWeight = FontWeight.Bold)}
                }
            }
        )
    }
}