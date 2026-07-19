package com.clementmistral.palier.ui.components.modals

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Schedule
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.clementmistral.palier.ui.components.LabeledField
import com.clementmistral.palier.ui.components.TimePickerDialog
import com.clementmistral.palier.ui.components.TreatmentCategory
import com.clementmistral.palier.ui.components.TreatmentCategorySelector
import com.clementmistral.palier.ui.components.TreatmentFrequency
import com.clementmistral.palier.ui.components.TreatmentFrequencySelector
import com.clementmistral.palier.ui.components.TreatmentTypeShape
import com.clementmistral.palier.ui.components.TreatmentTypeShapeSelector
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTreatmentModal(onDismissRequest: () -> Unit, sheetState: SheetState)  {
    var name by remember {mutableStateOf("")}
    var dose by remember {mutableStateOf("")}
    var treatmentTypeShape by remember { mutableStateOf<TreatmentTypeShape>(TreatmentTypeShape.TABLET) }
    var treatmentCategory by remember { mutableStateOf<TreatmentCategory>(TreatmentCategory.MAINTENANCE) }
    var treatmentFrequency by remember { mutableStateOf<TreatmentFrequency>(TreatmentFrequency.ONCE) }
    var hour by remember { mutableStateOf<LocalTime>(LocalTime.of(8, 0)) }
    var showTimePicker by remember { mutableStateOf(false) }

    ModalBottomSheet (onDismissRequest = onDismissRequest, sheetState = sheetState) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp).padding(bottom = 32.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Nouveau traitement de fond", style = MaterialTheme.typography.titleLarge)
                IconButton(
                    modifier = Modifier.size(48.dp),
                    onClick = onDismissRequest,
                    colors = IconButtonDefaults.filledTonalIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainer,
                        contentColor = Color.White
                    )
                ) {
                    Icon(Icons.Default.Close, contentDescription = null)
                }
            }
            LabeledField(
                value = name,
                onValueChange = { name = it },
                label = "Nom du médicament",
                placeholder = "Ex. Sertraline",
            )
            LabeledField(
                value = dose,
                onValueChange = { dose = it },
                label = "Dosage",
                placeholder = "Ex. 25mg",
            )
            TreatmentTypeShapeSelector(
                selected = treatmentTypeShape,
                onSelect = { treatmentTypeShape = it }
            )
            TreatmentCategorySelector(selected = treatmentCategory, onSelect = { treatmentCategory = it })
            if(treatmentCategory == TreatmentCategory.MAINTENANCE) {
                TreatmentFrequencySelector(selected = treatmentFrequency, onSelect = { treatmentFrequency = it })
                Column {
                    Text(
                        "Horaire",
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Box() {
                        OutlinedTextField(
                            value = hour.format(DateTimeFormatter.ofPattern("HH:mm")),
                            onValueChange = {},
                            readOnly = true,
                            shape = RoundedCornerShape(12.dp),
                            trailingIcon = {
                                Icon(Icons.Default.Schedule, contentDescription = null)
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .matchParentSize()
                                .clip(RoundedCornerShape(12.dp))
                                .clickable { showTimePicker = true }
                        )
                    }
                }
                if (showTimePicker) {
                    TimePickerDialog(
                        initial = hour,
                        onConfirm = {
                            hour = it                // on écrit la nouvelle heure dans TON état
                            showTimePicker = false    // et on ferme
                        },
                        onDismiss = { showTimePicker = false }
                    )
                }
            }
            Button(onClick = onDismissRequest) {
                Text("Ajouter le traitement")
            }
        }
    }
}