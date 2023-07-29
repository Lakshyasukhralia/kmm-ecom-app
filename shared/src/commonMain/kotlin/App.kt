import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import core.util.Toast
import feature.category.presentation.screen.category.CategoryScreen
import feature.home.presentation.screen.home.HomeScreen
import feature.item.domain.model.Item
import feature.item.presentation.screen.itemdetail.ItemDetailScreen
import feature.item.presentation.screen.itemlisting.ItemListingScreen
import feature.order.presentation.screen.orderlisting.OrderListingScreen
import feature.profile.presentation.screen.profile.ProfileScreen

@Composable
internal fun App() {

    var currentScreen: Screen by rememberSaveable { mutableStateOf(Screen.Home) }
    var currentItem: Item? by rememberSaveable { mutableStateOf(null) }

    MaterialTheme {
        when (currentScreen) {
            Screen.HelloWorld -> HelloWorldScreen(
                onButtonClick = { currentScreen = Screen.ItemListing }
            )

            Screen.Home -> HomeScreen(
                onButtonClick = { screen -> currentScreen = screen },
            )

            Screen.Category -> CategoryScreen(
                backAction = { currentScreen = Screen.Home },
                onButtonClick = { currentScreen = Screen.ItemListing }
            )

            Screen.SimpleViewModel -> SimpleScreen(
                backAction = { currentScreen = Screen.HelloWorld }
            )

            Screen.ItemListing -> ItemListingScreen(
                backAction = { currentScreen = Screen.Home },
                onItemClick = { item: Item ->
                    currentScreen = Screen.ItemDetail
                    currentItem = item
                }
            )

            Screen.ItemDetail -> ItemDetailScreen(
                backAction = { currentScreen = Screen.ItemListing },
                item = currentItem ?: Item(
                    "123",
                    "Sample Product Name",
                    "Compose Multiplatform for iOS is currently in Alpha, so now is a great time to explore the technology: Let’s build a simple app from start to finish in Kotlin. In the process, you’ll see how Compose Multiplatform and Kotlin Multiplatform enable sharing everything - from the networking layer, to business logic, to UI. The end result will be a small app that can load and display different bird pictures from an API, that will run on both Android and iOS!",
                    588f
                ),
                onCheckoutClick = { currentScreen = Screen.OrderListing }
            )

            Screen.OrderListing -> OrderListingScreen(
                backAction = { currentScreen = Screen.Home },
                onItemClick = {}
            )

            Screen.Profile -> ProfileScreen(
                backAction = { currentScreen = Screen.Home },
            )

            Screen.Setting -> {
                 currentScreen = Screen.Home
                Toast("Coming soon..")
            }
        }
    }
}

expect fun getPlatformName(): String
