package com.example.module2

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.module2.ui.theme.Module2Theme

class Task8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module2Theme {
                WaterTracker()
            }
        }
    }
}

@Composable
fun WaterTracker() {
    val primaryColor = Color.Cyan
    val secondaryColor = Color.Green
    val buttonTextColor = Color.White
    var waterCount by remember { mutableIntStateOf(0) }
    var waterGoalDaysCount by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Трекер воды",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor
                )

                Spacer(modifier = Modifier.height(48.dp))

                Text(
                    text = waterCount.toString(),
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = secondaryColor
                )

                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                    onClick = {
                        waterCount += 250
                        if (waterCount >= 1500) waterGoalDaysCount++
                    }
                ) {
                    Text(
                        text = "+250 мл",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = buttonTextColor
                    )
                }

                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                    onClick = {
                        if (waterCount < 1500) waterGoalDaysCount = 0
                        waterCount = 0
                    }
                ) {
                    Text(
                        text = "Завершить день",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = buttonTextColor
                    )
                }

                Text(
                    text = "Дней с 1500мл и больше подряд: $waterGoalDaysCount"
                )
            }
        })
}

@Preview(
    name = "Task 8",
    showBackground = true,
    showSystemUi = true,
    device = "spec:parent=pixel_8,orientation=portrait"
)
@Composable
fun WaterTrackerPreview() {
    Module2Theme {
        WaterTracker()
    }
}