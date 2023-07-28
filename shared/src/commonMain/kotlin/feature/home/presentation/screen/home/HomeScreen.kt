package feature.home.presentation.screen.home

import Screen
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.myapplication.common.MR
import dev.icerock.moko.resources.compose.fontFamilyResource
import feature.home.domain.model.HomeMenuItem
import feature.home.presentation.component.HomeMenuCard

@Composable
internal fun HomeScreen(
    onButtonClick: (screen: Screen) -> Unit
) {

    val menuList = listOf(
        HomeMenuItem("1", "Products", Screen.ItemListing),
        HomeMenuItem("2", "Orders", Screen.OrderListing),
        HomeMenuItem("3", "Profile", Screen.ItemListing),
        HomeMenuItem("4", "Settings", Screen.ItemListing),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black,
                title = {
                    Text(
                        text = "Menu",
                        fontFamily = fontFamilyResource(MR.fonts.montserrat_semi_bold.montserrat_semi_bold),
                        color = Color.White
                    )
                },
            )
        },
        content = { _ ->
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalArrangement = Arrangement.Center,
                content = {
                    items(menuList) { item ->
                        Box(modifier = Modifier.padding(5.dp)) {
                            HomeMenuCard(item) {
                                onButtonClick(item.screen)
                            }
                        }
                    }
                }
            )
        })
}