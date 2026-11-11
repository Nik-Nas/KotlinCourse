package com.example.module2

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import android.text.Layout
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.module2.ui.theme.Module2Theme

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            Module2Theme {
                Hello(Modifier, "Kotlin")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview (name = "Task 5", showBackground = true, showSystemUi = true, group = "Task 5")
@Composable fun Task5(){
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
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(Color.Gray),
                        contentAlignment = Alignment.Center,
                        content = {
                            Box(
                                modifier = Modifier
                                    .padding(vertical = 16.dp)
                                    .fillMaxHeight()
                                    .aspectRatio(1f)
                                    .background(Color.Red, CircleShape),
                                contentAlignment = Alignment.Center
                            )
                            {
                                Text(text = "АБ")
                            }
                        }
                    )
                }
            }
        )
    }
}