package feature.item.presentation.component

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapplication.common.MR
import dev.icerock.moko.resources.compose.fontFamilyResource

@Composable
fun RoundedButton(
    text: String = "Button",
    buttonColor: Color = Color.Black,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = buttonColor),
        onClick = { onClick() }) {
        Text(
            text = text, color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier.padding(5.dp),
            fontFamily = fontFamilyResource(MR.fonts.montserrat_semi_bold.montserrat_semi_bold)
        )
    }
}