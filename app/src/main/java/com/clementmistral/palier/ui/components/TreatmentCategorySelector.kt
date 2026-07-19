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

enum class TreatmentCategory(val label: String) {
    MAINTENANCE("Traitement de fond"), OPTIONAL("Au besoin")
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TreatmentCategorySelector(
    selected: TreatmentCategory,
    onSelect: (TreatmentCategory) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("Catégorie", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.padding(bottom = 8.dp))
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TreatmentCategory.entries.forEach { category -> FilterChip(selected = category == selected, onClick = { onSelect(category) }, label = {Text(category.label)}) }
        }
    }
}