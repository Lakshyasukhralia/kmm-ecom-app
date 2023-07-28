package feature.item.presentation.component

import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.myapplication.common.MR
import dev.icerock.moko.resources.compose.fontFamilyResource

@Composable
fun SearchBox(
    modifier: Modifier,
    onSearch: (String) -> Unit,
) {
    var searchText by remember {
        mutableStateOf("")
    }

    TextField(
        value = searchText,
        textStyle = TextStyle(
            fontFamily = fontFamilyResource(MR.fonts.montserrat_regular.montserrat_regular),
            fontSize = 18.sp
        ),
        onValueChange = {
            onSearch(it)
            searchText = it
        },
        placeholder = {
            Text(
                text = "Search",
                fontFamily = fontFamilyResource(MR.fonts.montserrat_regular.montserrat_regular),
                fontSize = 18.sp
            )
        },
        modifier = modifier,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Gray,
            disabledTextColor = Color.Transparent,
            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        trailingIcon = { Icon(Icons.Filled.Search, "search") }
    )
}