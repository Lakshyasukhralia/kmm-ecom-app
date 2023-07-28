package feature.category.presentation.screen.category

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
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
import core.util.BackHandler
import dev.icerock.moko.resources.compose.fontFamilyResource
import feature.category.domain.model.Category
import feature.category.presentation.component.CategoryCard

@Composable
internal fun CategoryScreen(
    backAction: () -> Unit,
    onButtonClick: () -> Unit
) {

    val categoryList = listOf(
        Category("1", "Category 1"),
        Category("1", "Category 1"),
        Category("1", "Category 1"),
        Category("1", "Category 1"),
        Category("1", "Category 1"),
        Category("1", "Category 1"),
        Category("1", "Category 1"),
        Category("1", "Category 1"),
        Category("1", "Category 1"),
        Category("1", "Category 1")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black,
                title = {
                    Text(
                        text = "Category",
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
            LazyVerticalGrid(
                columns = GridCells.Adaptive(128.dp),
                contentPadding = PaddingValues(10.dp),
                content = {
                    items(categoryList) { item ->
                        Box(modifier = Modifier.padding(5.dp)) {
                            CategoryCard(item) {
                                onButtonClick()
                            }
                        }
                    }
                }
            )
        })
}