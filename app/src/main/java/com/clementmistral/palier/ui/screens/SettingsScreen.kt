package com.clementmistral.palier.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Switch
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.clementmistral.palier.ui.components.SectionHeader
import com.clementmistral.palier.ui.components.SettingLink
import com.clementmistral.palier.ui.theme.cardBorder

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(modifier: Modifier = Modifier, onTreatmentClick: () -> Unit, onReminderClick: () -> Unit) {

    var unlockCode by remember { mutableStateOf(false) }

    Column(
        modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Text(
            "Réglages",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(start = 16.dp, top = 12.dp)
        )
        Column(modifier.padding(horizontal=16.dp)) {
            SectionHeader("Mon traitement")
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                SettingLink("Traitement", "Médicaments, dosages, horaires", onClick = onTreatmentClick)
                SettingLink("Rappels", "Horaires, relance, snooze", onClick = onReminderClick)
            }
        }
        Column(modifier.padding(16.dp)) {
            SectionHeader("Application")
            Card(
                onClick = { unlockCode = !unlockCode },
                modifier = modifier.fillMaxWidth().border(2.dp, MaterialTheme.colorScheme.cardBorder,
                    RoundedCornerShape(16.dp)
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                ),) {
                Row(
                    modifier.fillMaxWidth().padding(horizontal = 16.dp).height(64.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text("Code de déverouillage")
                    Switch(checked = unlockCode, onCheckedChange = { unlockCode = it })
                }

            }
        }
    }
}