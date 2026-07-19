package com.clementmistral.palier.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.clementmistral.palier.ui.components.SectionHeader

@Composable
fun ReminderScreen(modifier: Modifier = Modifier, onBack: () -> Unit) {
    Surface(modifier = Modifier.fillMaxSize().windowInsetsPadding(WindowInsets.statusBars), color = MaterialTheme.colorScheme.background) {
        Column(modifier.padding(horizontal = 16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                IconButton(modifier = Modifier.size(48.dp), onClick = onBack, colors = IconButtonDefaults.filledTonalIconButtonColors(
                    containerColor = MaterialTheme.colorScheme.surfaceContainer,
                    contentColor = Color.White
                )) {
                    Icon(Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = null)
                }
                Text("Rappels", style = MaterialTheme.typography.titleLarge, modifier = Modifier.padding(start = 16.dp, top = 12.dp, bottom = 8.dp))
            }
        }
    }
}