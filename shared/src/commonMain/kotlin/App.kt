import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import feature.category.presentation.screen.CategoryScreen
import feature.item.presentation.screen.itemlisting.ItemListingScreen

@Composable
internal fun App() {
    var currentScreen: Screen by rememberSaveable { mutableStateOf(Screen.Category) }

    MaterialTheme {
        when (currentScreen) {
            Screen.HelloWorld -> HelloWorldScreen(
                onButtonClick = { currentScreen = Screen.ItemListing }
            )

            Screen.Category -> CategoryScreen(
                backAction = { currentScreen = Screen.HelloWorld },
                onButtonClick = { currentScreen = Screen.ItemListing }
            )

            Screen.SimpleViewModel -> SimpleScreen(
                backAction = { currentScreen = Screen.HelloWorld }
            )

            Screen.ItemListing -> ItemListingScreen(
                backAction = { currentScreen = Screen.Category }
            )
        }
    }
}

expect fun getPlatformName(): String
