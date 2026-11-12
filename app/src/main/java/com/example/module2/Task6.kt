package com.example.module2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.module2.ui.theme.Module2Theme

class Task6 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2Theme {
                Task61(Modifier)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task61(modifier: Modifier = Modifier) {
    Module2Theme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "FirstComposeProject",
                            color = Color.White
                        )
                    },
                    colors = TopAppBarDefaults
                        .topAppBarColors(
                            containerColor = Color(0xFF6200EE),
                        )
                )
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding),
                    content = {
                        Box(
                            modifier = modifier
                                .background(color = Color.Black)
                                .size(240.dp, 120.dp),
                            contentAlignment = Alignment.TopEnd,
                            content = {
                                Image(painter = painterResource(id =R.drawable.circle),
                                    contentDescription = "Red circle",
                                )
                            }
                        )
                    }
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task62(modifier: Modifier = Modifier) {
    Module2Theme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "FirstComposeProject",
                            color = Color.White
                        )
                    },
                    colors = TopAppBarDefaults
                        .topAppBarColors(
                            containerColor = Color(0xFF6200EE),
                        )
                )
            },
            content = { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding),
                    content = {
                        Box(
                            modifier = modifier
                                .background(color = Color.Blue)
                                .size(240.dp, 120.dp),
                            contentAlignment = Alignment.Center,
                            content = {
                                Image(
                                    painter = painterResource(id = R.drawable.circle),
                                    contentDescription = "Red circle",
                                    contentScale = ContentScale.FillBounds,
                                    modifier = Modifier
                                        .fillMaxSize().alpha(0.5f)
                                )
                            }
                        )
                    }
                )
            }
        )
    }
}

@Preview(
    name = "portrait",
    showBackground = true,
    showSystemUi = true,
    device = "spec:parent=pixel_8,orientation=portrait"
)
@Composable
fun Task61Preview() {
    Module2Theme {
        Task61(Modifier)
    }
}

@Preview(
    name = "portrait",
    showBackground = true,
    showSystemUi = true,
    device = "spec:parent=pixel_8,orientation=portrait"
)
@Composable
fun Task62Preview() {
    Module2Theme {
        Task62(Modifier)
    }
}