package com.example.fixmate.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fixmate.ui.theme.FixmateTheme
import com.example.fixmate.ui.theme.TertiaryFixed

@Composable
fun SellerDashboardScreen() {
    var isApproved by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = { MobileNavBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            DashboardHeader()
            Spacer(modifier = Modifier.height(24.dp))
            
            if (!isApproved) {
                ApprovalBanner(onVerify = { isApproved = true })
                Spacer(modifier = Modifier.height(24.dp))
            }
            
            StatsOverview()
            Spacer(modifier = Modifier.height(32.dp))
            
            ListingManagement(isEnabled = isApproved)
            Spacer(modifier = Modifier.height(32.dp))
            
            RecentOrdersTable()
            Spacer(modifier = Modifier.height(32.dp))
            
            Footer()
        }
    }
}

@Composable
fun DashboardHeader() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text("Welcome back, Sarah", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
            Text("Manage your services and track business growth.", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Box(modifier = Modifier.size(40.dp).clip(CircleShape).background(MaterialTheme.colorScheme.surfaceContainer).padding(8.dp)) {
                Icon(Icons.Outlined.Notifications, contentDescription = null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
                Box(modifier = Modifier.size(8.dp).clip(CircleShape).background(MaterialTheme.colorScheme.error).align(Alignment.TopEnd))
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .border(2.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.2f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("SK", color = MaterialTheme.colorScheme.onPrimaryContainer, fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun ApprovalBanner(onVerify: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = TertiaryFixed),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(modifier = Modifier.size(48.dp).clip(CircleShape).background(MaterialTheme.colorScheme.tertiary.copy(alpha = 0.1f)), contentAlignment = Alignment.Center) {
                Icon(Icons.Default.Lock, contentDescription = null, tint = MaterialTheme.colorScheme.tertiary)
            }
            Column(modifier = Modifier.weight(1f)) {
                Text("Complete Your Setup", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onTertiaryContainer)
                Text("Your payment verification is pending. Manual payment via bKash or Nagad is required.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onTertiaryContainer)
            }
            Button(
                onClick = onVerify,
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Verify Now", fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun StatsOverview() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        StatCard("Active Listings", "08", "+12%", Icons.Default.ListAlt, MaterialTheme.colorScheme.primary, Modifier.weight(1f))
        StatCard("Inquiries", "24", "-4%", Icons.Default.ChatBubble, MaterialTheme.colorScheme.tertiary, Modifier.weight(1f))
        StatCard("Earnings", "৳45.2k", "+28%", Icons.Default.AccountBalanceWallet, MaterialTheme.colorScheme.secondary, Modifier.weight(1f))
    }
}

@Composable
fun StatCard(label: String, value: String, trend: String, icon: ImageVector, color: Color, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Box(modifier = Modifier.size(36.dp).clip(RoundedCornerShape(8.dp)).background(color.copy(alpha = 0.1f)), contentAlignment = Alignment.Center) {
                    Icon(icon, contentDescription = null, tint = color, modifier = Modifier.size(20.dp))
                }
                Text(trend, style = MaterialTheme.typography.labelSmall, color = if (trend.startsWith("+")) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.error)
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(label.uppercase(), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            Text(value, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ListingManagement(isEnabled: Boolean) {
    Column(modifier = Modifier.alpha(if (isEnabled) 1f else 0.4f)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text("Service Listings", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
            Button(onClick = { }, enabled = isEnabled, shape = RoundedCornerShape(8.dp)) {
                Icon(Icons.Default.Add, contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text("Create New")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        ListingCard("Enterprise UI/UX Design System", "৳12,000", "Approved", isEnabled)
    }
}

@Composable
fun ListingCard(title: String, price: String, status: String, isEnabled: Boolean) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column {
            Box(modifier = Modifier.fillMaxWidth().height(160.dp).background(Color.LightGray)) {
                Surface(
                    modifier = Modifier.padding(12.dp).align(Alignment.TopEnd),
                    color = MaterialTheme.colorScheme.secondaryContainer,
                    shape = CircleShape
                ) {
                    Text(status, modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSecondaryContainer)
                }
            }
            Column(modifier = Modifier.padding(16.dp)) {
                Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Payments, contentDescription = null, modifier = Modifier.size(16.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(price, style = MaterialTheme.typography.bodySmall)
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Default.Schedule, contentDescription = null, modifier = Modifier.size(16.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("14 Days", style = MaterialTheme.typography.bodySmall)
                    }
                }
            }
        }
    }
}

@Composable
fun RecentOrdersTable() {
    Column {
        Text("Recent Orders", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.3f))
        ) {
            Column {
                OrderRow("Rahim J.", "Landing Page Redesign", "৳4,500", "IN PROGRESS")
                Divider(color = MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.2f))
                OrderRow("Ayesha S.", "Logo Design Package", "৳2,000", "PENDING")
            }
        }
    }
}

@Composable
fun OrderRow(client: String, service: String, amount: String, status: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(client, style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
            Text(service, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(amount, style = MaterialTheme.typography.labelLarge, fontWeight = FontWeight.Bold)
            Surface(
                color = if (status == "PENDING") MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.1f) else MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.2f),
                shape = CircleShape
            ) {
                Text(
                    status,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = if (status == "PENDING") MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun MobileNavBar() {
    NavigationBar(containerColor = Color.White) {
        NavigationBarItem(selected = true, onClick = {}, icon = { Icon(Icons.Default.Dashboard, null) }, label = { Text("Home") })
        NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Work, null) }, label = { Text("Services") })
        NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Forum, null) }, label = { Text("Inbox") })
        NavigationBarItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.AccountBalanceWallet, null) }, label = { Text("Wallet") })
    }
}

@Composable
fun Footer() {
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 24.dp)) {
        Divider()
        Spacer(modifier = Modifier.height(24.dp))
        Text("ProMarket", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Black)
        Text("© 2024 ProMarket Enterprise Solutions. All rights reserved.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Preview(showBackground = true)
@Composable
fun SellerDashboardPreview() {
    FixmateTheme {
        SellerDashboardScreen()
    }
}
