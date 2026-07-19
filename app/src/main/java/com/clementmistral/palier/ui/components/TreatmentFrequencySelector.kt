package com.clementmistral.palier.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilterChip
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class TreatmentFrequency(val label: String, val times: Int?) {
    ONCE("1x/jour", 1), TWICE("2x/jour", 2), THRICE("3x/jour", 3), QUADRICE("4x/jour", 4)
}
@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TreatmentFrequencySelector(
    selected: TreatmentFrequency,
    onSelect: (TreatmentFrequency) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column (modifier = modifier) {
        Text("Fréquence", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.padding(bottom = 8.dp))
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TreatmentFrequency.entries.forEach { frequency -> FilterChip(selected = frequency == selected, onClick = { onSelect(frequency) }, label = {Text(frequency.label)}) }
        }
    }
}

