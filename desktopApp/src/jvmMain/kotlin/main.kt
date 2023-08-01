import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import core.di.initKoin

fun main() {
    initKoin()
    application {
        Window(onCloseRequest = ::exitApplication) {
            MainView()
        }
    }
}
