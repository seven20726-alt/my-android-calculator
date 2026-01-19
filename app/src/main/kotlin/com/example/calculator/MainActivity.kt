package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CalculatorScreen()
                }
            }
        }
    }
}

@Composable
fun CalculatorScreen() {
    var aText by remember { mutableStateOf("") }
    var bText by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "简单计算器", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(
            value = aText,
            onValueChange = { aText = it },
            label = { Text("数字 A") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = bText,
            onValueChange = { bText = it },
            label = { Text("数字 B") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row {
            Button(onClick = {
                val a = aText.toDoubleOrNull()
                val b = bText.toDoubleOrNull()
                result = if (a != null && b != null) (a + b).toString() else "输入无效"
            }) { Text("+") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                val a = aText.toDoubleOrNull()
                val b = bText.toDoubleOrNull()
                result = if (a != null && b != null) (a - b).toString() else "输入无效"
            }) { Text("-") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                val a = aText.toDoubleOrNull()
                val b = bText.toDoubleOrNull()
                result = if (a != null && b != null) (a * b).toString() else "输入无效"
            }) { Text("×") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                val a = aText.toDoubleOrNull()
                val b = bText.toDoubleOrNull()
                result = if (a != null && b != null && b != 0.0) (a / b).toString() else "无效或除以 0"
            }) { Text("÷") }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "结果: ${result ?: ""}", style = MaterialTheme.typography.bodyLarge)
    }
}