package feature.order.presentation.screen.orderlisting

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapplication.common.MR
import core.util.BackHandler
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import dev.icerock.moko.resources.compose.fontFamilyResource
import feature.order.domain.model.Order
import feature.item.presentation.component.ErrorView
import feature.item.presentation.component.OrderListingCard

@Composable
internal fun OrderListingScreen(
    backAction: () -> Unit,
    viewModel: OrderListingViewModel = getViewModel(
        key = "order-listing-screen",
        factory = viewModelFactory { OrderListingViewModel() }
    ),
    onItemClick: (order: Order) -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black,
                title = {
                    Text(
                        text = "My Orders",
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                uiState.orders?.let {
                    items(uiState.orders!!) { item ->
                        OrderListingCard(item) { onItemClick(item) }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
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
                if (uiState.orders.isNullOrEmpty() && !uiState.isLoading)
                    Text(
                        text = "No orders yet :|",
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