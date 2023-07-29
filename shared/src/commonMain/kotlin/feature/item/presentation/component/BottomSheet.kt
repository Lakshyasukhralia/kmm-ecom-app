package feature.item.presentation.component

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import feature.item.domain.model.Item

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CheckoutBottomSheet(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Expanded)
    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = { ItemListingCard(Item("123", "123", "123", 1f)) }
    ) {}
}