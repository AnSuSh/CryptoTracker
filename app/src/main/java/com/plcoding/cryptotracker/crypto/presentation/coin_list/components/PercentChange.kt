package com.plcoding.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.cryptotracker.crypto.presentation.models.DisplayableNumber
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme
import com.plcoding.cryptotracker.ui.theme.greenBackground

@Composable
fun PercentChange(
    data: DisplayableNumber,
    modifier: Modifier = Modifier
) {
    val contentColor = if (data.value < 0) {
        MaterialTheme.colorScheme.onErrorContainer
    } else {
        Color.Green
    }
    val backgroundColor = if (data.value < 0) {
        MaterialTheme.colorScheme.error
    } else {
        greenBackground
    }
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(100f))
            .background(backgroundColor),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (data.value < 0) Icons.Default.KeyboardArrowDown else
                Icons.Default.KeyboardArrowUp,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = contentColor
        )
        Text(
            text = "${data.formatted} % ",
            color = contentColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview
@Composable
private fun PercentChangePreviewPositive() {
    CryptoTrackerTheme {
        PercentChange(
            DisplayableNumber(12.0, "12.0")
        )
    }
}

@Preview
@Composable
private fun PercentChangePreviewNegative() {
    CryptoTrackerTheme {
        PercentChange(
            DisplayableNumber(-12.0, "12.0")
        )
    }
}