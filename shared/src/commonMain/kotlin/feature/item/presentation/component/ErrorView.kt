package feature.item.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ErrorView(error: String) {

    val err by remember { mutableStateOf(error) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Red)
            .padding(4.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = err,
            color = Color.White,
        )
    }

}