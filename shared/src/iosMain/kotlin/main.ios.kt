import androidx.compose.ui.window.ComposeUIViewController
import core.di.initKoin

actual fun getPlatformName(): String = "iOS"

fun MainViewController() = ComposeUIViewController {
    initKoin()
    App()
}