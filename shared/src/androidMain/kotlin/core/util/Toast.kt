package core.util

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
actual fun Toast(message: String) {
    Toast.makeText(
        LocalContext.current,
        message,
        Toast.LENGTH_SHORT
    ).show()
}