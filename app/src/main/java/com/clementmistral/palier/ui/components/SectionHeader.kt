package com.clementmistral.palier.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class SectionAction(
    val icon: ImageVector,
    val contentDescription: String?,
    val onClick: () -> Unit
)

@Composable
fun SectionHeader(
    title: String,
    modifier: Modifier = Modifier,
    action: SectionAction? = null

) {
    Row (
        modifier = modifier.fillMaxWidth().padding(top = 10.dp, bottom = 3.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
    Text(
        text = title.uppercase(),
        style = MaterialTheme.typography.labelMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        letterSpacing = 0.8.sp,
        modifier = modifier.padding(
            top = 24.dp,
            bottom = 24.dp
        )
    )
        action?.let {
            FilledTonalIconButton(onClick = it.onClick) {
                Icon(it.icon, contentDescription = it.contentDescription)
            }
        }
    }
}