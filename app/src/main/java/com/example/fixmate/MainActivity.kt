package com.example.fixmate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AdminPanelSettings
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Store
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.fixmate.ui.screens.*
import com.example.fixmate.ui.theme.FixmateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FixmateTheme {
                var currentScreen by remember { mutableStateOf("landing") }
                
                // Navigation Logic
                val handleAuthSuccess: (String) -> Unit = { email ->
                    val lowerEmail = email.lowercase()
                    currentScreen = when {
                        lowerEmail.contains("admin") -> "admin"
                        lowerEmail.contains("seller") -> "seller"
                        else -> "buyer" // Default to Buyer Dashboard
                    }
                }

                val navigateToLanding = { currentScreen = "landing" }
                val navigateToSignIn = { currentScreen = "signin" }
                val navigateToSignUp = { currentScreen = "signup" }
                val navigateToDetail = { currentScreen = "detail" }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (currentScreen != "signin" && currentScreen != "signup") {
                            NavigationBar {
                                NavigationBarItem(
                                    selected = currentScreen == "landing" || currentScreen == "buyer",
                                    onClick = { currentScreen = if(currentScreen == "buyer") "buyer" else "landing" },
                                    icon = { Icon(Icons.Default.Home, null) },
                                    label = { Text("Home") }
                                )
                                NavigationBarItem(
                                    selected = currentScreen == "messaging",
                                    onClick = { currentScreen = "messaging" },
                                    icon = { Icon(Icons.Default.Mail, null) },
                                    label = { Text("Inbox") }
                                )
                                NavigationBarItem(
                                    selected = currentScreen == "seller",
                                    onClick = { currentScreen = "seller" },
                                    icon = { Icon(Icons.Default.Store, null) },
                                    label = { Text("Seller") }
                                )
                                NavigationBarItem(
                                    selected = currentScreen == "admin",
                                    onClick = { currentScreen = "admin" },
                                    icon = { Icon(Icons.Default.AdminPanelSettings, null) },
                                    label = { Text("Admin") }
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        when (currentScreen) {
                            "landing" -> LandingScreen(
                                onSignIn = navigateToSignIn,
                                onGetStarted = navigateToSignIn,
                                onBecomeSeller = navigateToSignUp,
                                onCategoryClick = { navigateToDetail() }
                            )
                            "signin" -> SignInScreen(
                                onBack = navigateToLanding,
                                onLoginSuccess = handleAuthSuccess,
                                onSignUpClick = navigateToSignUp
                            )
                            "signup" -> SignUpScreen(
                                onBack = navigateToSignIn,
                                onSignUpSuccess = handleAuthSuccess
                            )
                            "buyer" -> BuyerDashboardScreen()
                            "detail" -> ServiceDetailScreen(onBack = navigateToLanding)
                            "messaging" -> MessagingScreen()
                            "seller" -> SellerDashboardScreen()
                            "admin" -> AdminApprovalsScreen()
                        }
                    }
                }
            }
        }
    }
}
