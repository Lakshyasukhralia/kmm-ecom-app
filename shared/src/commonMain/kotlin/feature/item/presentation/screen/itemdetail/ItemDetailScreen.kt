package feature.item.presentation.screen.itemdetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapplication.common.MR
import com.seiko.imageloader.rememberImagePainter
import core.util.BackHandler
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.resources.compose.fontFamilyResource
import feature.item.domain.model.Item
import feature.item.presentation.component.ErrorView
import feature.item.presentation.component.RoundedButton
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterialApi::class)
@Composable
internal fun ItemDetailScreen(
    backAction: () -> Unit,
    viewModel: ItemDetailViewModel = getViewModel(
        key = "item-detail-screen",
        factory = viewModelFactory { ItemDetailViewModel() }
    ),
    item: Item,
    onCheckoutClick: () -> Unit = {}
) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black,
                title = {
                    Text(
                        text = item.name,
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
            BackHandler(true) { backAction() }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = rememberImagePainter("https://picsum.photos/200"),
                            contentDescription = "image",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.fillMaxWidth().height(200.dp)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = item.name,
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontFamily = fontFamilyResource(MR.fonts.montserrat_semi_bold.montserrat_semi_bold)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = item.description,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        fontFamily = fontFamilyResource(MR.fonts.montserrat_regular.montserrat_regular)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
                Column(modifier = Modifier.weight(1f, false)) {
                    RoundedButton(
                        text = "Checkout ₹${item.price}",
                        onClick = { onCheckoutClick() },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                if (uiState.isLoading) CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.Black
                )
                if (uiState.error.isNotEmpty()) ErrorView(error = uiState.error)
            }
        })
}