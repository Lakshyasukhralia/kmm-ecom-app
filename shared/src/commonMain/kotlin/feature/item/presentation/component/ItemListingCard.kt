package feature.item.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapplication.common.MR
import dev.icerock.moko.resources.compose.fontFamilyResource
import feature.item.domain.model.Item
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ItemListingCard(
    item: Item,
    onClick: () -> Unit = {}
) {

    Card(
        elevation = 3.dp,
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .wrapContentSize()
            .clickable { onClick() }
            .height(IntrinsicSize.Min),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Card(
                modifier = Modifier
                    .height(125.dp)
                    .width(125.dp)
                    .padding(10.dp)
                    .weight(1f)
                    .align(Alignment.CenterVertically),
                elevation = 5.dp
            ) {
                Image(
                    painter = painterResource("compose-multiplatform.xml"),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxSize()
                    .weight(2f)
                    .padding(4.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        text = item.name,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        fontFamily = fontFamilyResource(MR.fonts.montserrat_regular.montserrat_regular)
                    )
                    Text(
                        text = item.description,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        fontFamily = fontFamilyResource(MR.fonts.montserrat_regular.montserrat_regular)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "₹ ${item.price}",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    fontFamily = fontFamilyResource(MR.fonts.montserrat_regular.montserrat_regular)
                )
            }
            Column(
                modifier = Modifier
                    .weight(.5f)
                    .padding(top = 15.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box {
                    Icon(
                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "more",
                        modifier = Modifier
                            .height(25.dp)
                            .width(25.dp)
                            .clickable { }
                    )
                }
            }
        }
    }
}