package com.clementmistral.palier.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val PalierShapes = Shapes(
    extraSmall = RoundedCornerShape(6.dp),   // badges
    small = RoundedCornerShape(11.dp),       // cellules calendrier
    medium = RoundedCornerShape(14.dp),      // cartes compactes / boutons
    large = RoundedCornerShape(16.dp),       // cartes standard (dominant)
    extraLarge = RoundedCornerShape(18.dp),  // grandes cartes stat
)