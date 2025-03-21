package com.example.travelplanner.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.travelplanner.R
import com.example.travelplanner.domain.model.User

@Composable
fun LoginScreen(navController: NavController) {

    // States for username, password, and the alert dialog
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showAlert by remember { mutableStateOf(false) }

    // Get default values from strings.xml
    val defaultUser = stringResource(id = R.string.default_user)
    val defaultPass = stringResource(id = R.string.default_pass)

    // Define the testUser
    val testUser = User(
        userId = "testUser123",
        email = defaultUser,
        password = defaultPass,
        firstName = "Test",
        lastName = "User",
        trips = emptyList(),
        imageURL = "https://example.com/user-avatar.png"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login Screen", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                if (username == defaultUser && password == defaultPass) {
                    // Navigate to Home and remove Login from the back stack
                    navController.navigate("home") {
                        popUpTo("login") { inclusive = true }
                    }
                } else {
                    showAlert = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }

    // Show an alert dialog if the login fails
    if (showAlert) {
        AlertDialog(
            onDismissRequest = { showAlert = false },
            title = { Text("Login Failed") },
            text = { Text("Invalid username or password.") },
            confirmButton = {
                Button(onClick = { showAlert = false }) {
                    Text("OK")
                }
            }
        )
    }
}

