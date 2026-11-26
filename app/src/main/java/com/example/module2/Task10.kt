package com.example.module2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.module2.ui.theme.Module2Theme
import kotlin.random.Random

class Task10 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartScreen()
        }
    }

    data class Cart(
        val products: List<Product>
    )

    data class Product(
        val id: Int,
        val name: String,
        val price: Int
    )

    @Composable
    fun ShoppingCartScreen() {
        var products by remember {
            mutableStateOf(
                listOf(
                    Product(0, "Товар #1", 100),
                    Product(1, "Товар #2", 150),
                    Product(2, "Товар #3", 56)
                )
            )
        }
        var totalSum by remember { mutableIntStateOf(0) }
        var productSize by remember { mutableIntStateOf(0) }
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            content = { paddingValues ->
                Column(modifier = Modifier.padding(paddingValues)) {
                    totalSum = 0
                    productSize = 0
                    for (product in products) {
                        Text(text = product.name + " - " + product.price + " рублей")
                        totalSum += product.price
                        productSize++
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Товаров на сумму: $totalSum рублей")
                    AddProductSection(totalSum) {
                        products = products + Product(
                            id = products.size,
                            name = "Товар #${products.size + 1}",
                            price = Random.nextInt(0, 100)
                        )
                    }
                    RemoveProductSection(productSize) {
                        products = products.dropLast(1)
                    }
                }
            }
        )
    }

    @Composable
    fun AddProductSection(totalSum: Int, onAdd: () -> Unit) {
        // Если сумма заказа больше 500, то показываем сообщение о бесплатной доставке
        val context = LocalContext.current
        LaunchedEffect(totalSum > 500) {
            if (totalSum > 500) {
                Toast.makeText(
                    context,
                    "Доставка бесплатная!",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        }
        Button(onClick = onAdd) {
            Text(text = "Добавить товар")
        }
    }

    @Composable
    fun RemoveProductSection(productSize: Int,
        onRemove: () -> Unit
    ) {
        Log.i("REMOVE", "$productSize")
        if (productSize > 0) {
            Button(onClick = onRemove) {
                Text(text = "Удалить товар")
            }
        }
    }

    @Preview(
        name = "Task 10",
        showBackground = true,
        showSystemUi = true,
        device = "spec:parent=pixel_8,orientation=portrait"
    )
    @Composable
    fun Task10Preview() {
        Module2Theme {
            ShoppingCartScreen()
        }
    }
}