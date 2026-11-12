package com.example.module2

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.module2.ui.theme.Module2Theme

class Task7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2Theme {
                Task71()
            }
        }
    }
}

data class UserInfo(val label: String, val value: String)

data class User(val info: List<UserInfo>)

val users = listOf(
    User(
        info = listOf(
            UserInfo("Имя", "Евгений"),
            UserInfo("Отчество", "Андреевич"),
            UserInfo("Фамилия", "Лукашин"),
            UserInfo("Мобильный телефон", "+7 495 495 95 95"),
            UserInfo("Адрес", "г. Москва, 3-я улица Строителей, д. 25, кв. 12")
        )
    ),
    User(
        info = listOf(
            UserInfo("Имя", "Василий"),
            UserInfo("Отчество", "Егорович"),
            UserInfo("Фамилия", "Кузякин"),
            UserInfo("Мобильный телефон", "---"),
            UserInfo("Адрес", "Ивановская область, дер. Крутово, д. 4")
        )
    ),
    User(
        info = listOf(
            UserInfo("Имя", "Людмила"),
            UserInfo("Отчество", "Прокофьевна"),
            UserInfo("Фамилия", "Калугина"),
            UserInfo("Мобильный телефон", "+7 495 788 78 78"),
            UserInfo("Адрес", "г. Москва, Большая Никитская, д. 43, кв. 290")
        )
    )
)

@Composable
fun DisplayUser(user: User) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .background(color = Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.padding(7.dp)) {
            user.info.forEach { dataLine ->
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "${dataLine.label}: ${dataLine.value}",
                    fontSize = 14.sp,
                    lineHeight = 18.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task71() {
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
                    modifier = Modifier.padding(innerPadding),
                    content = {
                        users[0].info.forEach { user ->
                            Text(
                                text = "${user.label}: ${user.value}",
                                fontSize = 14.sp,
                                lineHeight = 15.sp
                            )
                        }
                    }
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task72() {
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
                    modifier = Modifier.padding(innerPadding),
                    content = {
                        users.forEach { user ->
                            DisplayUser(user)
                        }
                    }
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Task73() {
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
                    modifier = Modifier.padding(innerPadding),
                    content = {
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                                .background(color = Color.LightGray),
                            contentAlignment = Alignment.Center
                        ) {
                            Row(
                                modifier = Modifier.padding(7.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column(modifier = Modifier.weight(19f)) {
                                    users[0].info.forEach { dataLine ->
                                        Text(
                                            modifier = Modifier
                                                .fillMaxWidth(),
                                            text = "${dataLine.label}: ${dataLine.value}",
                                            fontSize = 14.sp,
                                            lineHeight = 18.sp,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                                Image(
                                    painter = painterResource(R.drawable.instagram_icon),
                                    contentDescription = "instagram icon",
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
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
fun Task71Preview() {
    Module2Theme {
        Task71()
    }
}

@Preview(
    name = "portrait",
    showBackground = true,
    showSystemUi = true,
    device = "spec:parent=pixel_8,orientation=portrait"
)
@Composable
fun Task72Preview() {
    Module2Theme {
        Task72()
    }
}

@Preview(
    name = "portrait",
    showBackground = true,
    showSystemUi = true,
    device = "spec:parent=pixel_8,orientation=portrait"
)
@Composable
fun Task73Preview() {
    Module2Theme {
        Task73()
    }
}