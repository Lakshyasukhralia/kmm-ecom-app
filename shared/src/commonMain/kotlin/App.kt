import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import feature.item.presentation.screen.itemlisting.ItemListingScreen

@Composable
internal fun App() {
    var currentScreen: Screen by rememberSaveable { mutableStateOf(Screen.ItemListing) }

    MaterialTheme {
        when (currentScreen) {
            Screen.HelloWorld -> HelloWorldScreen(
                onButtonClick = { currentScreen = Screen.ItemListing }
            )

            Screen.SimpleViewModel -> SimpleScreen(
                backAction = { currentScreen = Screen.HelloWorld }
            )

            Screen.ItemListing -> ItemListingScreen(
                backAction = { currentScreen = Screen.HelloWorld }
            )
        }
    }
}

expect fun getPlatformName(): String
