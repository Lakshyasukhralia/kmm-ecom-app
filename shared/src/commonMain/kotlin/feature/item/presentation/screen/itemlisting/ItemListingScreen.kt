package feature.item.presentation.screen.itemlisting

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.myapplication.common.MR
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.resources.compose.fontFamilyResource
import feature.item.domain.model.Item
import feature.item.presentation.component.ItemListingCard

@Composable
internal fun ItemListingScreen(
    backAction: () -> Unit,
    viewModel: ItemListingViewModel = getViewModel(
        key = "item-listing-screen",
        factory = viewModelFactory { ItemListingViewModel() }
    )
) {

    val state = viewModel.state

    val itemList = state.items

//        listOf<Item>(
//        Item("1", "Product 1", "Lorem Ipsum Something", 100f),
//        Item("2", "Product 2", "Lorem Ipsum Something", 500f),
//        Item("3", "Product 3", "Lorem Ipsum Something", 300f),
//        Item("4", "Product 4", "Lorem Ipsum Something", 200f),
//        Item("5", "Product 5", "Lorem Ipsum Something", 400f),
//        Item("2", "Product 2", "Lorem Ipsum Something", 500f),
//        Item("3", "Product 3", "Lorem Ipsum Something", 300f),
//        Item("4", "Product 4", "Lorem Ipsum Something", 200f),
//        Item("5", "Product 5", "Lorem Ipsum Something", 400f),
//    )
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black,
                title = {
                    Text(
                        text = "Item Listings",
                        fontFamily = fontFamilyResource(MR.fonts.montserrat_semi_bold.montserrat_semi_bold),
                        color = Color.White
                    )
                },
                navigationIcon = {
                    IconButton(onClick = backAction) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            )
        },
        content = { _ ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                itemList?.let {
                    items(itemList) { item ->
                        ItemListingCard(item) {}
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        })
}