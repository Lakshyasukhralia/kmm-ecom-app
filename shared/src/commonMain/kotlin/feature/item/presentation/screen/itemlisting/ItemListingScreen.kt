package feature.item.presentation.screen.itemlisting

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapplication.common.MR
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.resources.compose.fontFamilyResource
import feature.item.presentation.component.ErrorView
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
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                if (state.isLoading) CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Black
                )
                if (state.error.isNotEmpty()) ErrorView(error = state.error)
                if (itemList.isNullOrEmpty() && !state.isLoading)
                    Text(
                        text = "No items available :(",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        fontFamily = fontFamilyResource(MR.fonts.montserrat_semi_bold.montserrat_semi_bold),
                        fontSize = 24.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                            .align(Alignment.Center)
                    )
            }
        })
}