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

enum class TreatmentTypeShape(val label: String) {
    TABLET("Comprimé"), CAPSULE("Gélule"), DROPS("Gouttes"), SACHET("Sachet"), INJECTION("Injection")

}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TreatmentTypeShapeSelector(
    selected: TreatmentTypeShape,
    onSelect: (TreatmentTypeShape) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text("Forme", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.padding(bottom = 8.dp))
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            TreatmentTypeShape.entries.forEach { shape -> FilterChip(selected = shape == selected, onClick = { onSelect(shape) }, label = {Text(shape.label)}) }
        }
    }
}