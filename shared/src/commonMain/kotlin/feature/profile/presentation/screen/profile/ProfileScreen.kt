package feature.profile.presentation.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myapplication.common.MR
import core.util.BackHandler
import dev.icerock.moko.resources.compose.fontFamilyResource
import feature.profile.domain.model.User
import feature.profile.presentation.component.ProfileItemCard
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun ProfileScreen(
    backAction: () -> Unit
) {

    val user = User("Lakshya Sukhralia", "917297959197", "lakshyasukhralia97@gmail.com")

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.Black,
                title = {
                    Text(
                        text = "My Profile",
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
        }) { _ ->
        BackHandler(true) { backAction() }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource("profile.xml"),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(75.dp)
                        .width(75.dp)
                        .weight(1f)
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f)
                        .padding(10.dp),
                ) {
                    Text(
                        text = user.name,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = fontFamilyResource(MR.fonts.montserrat_semi_bold.montserrat_semi_bold)
                    )
                    Text(
                        text = "+${user.phoneNumber?.take(2)}-${user.phoneNumber?.takeLast(10)}",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = fontFamilyResource(MR.fonts.montserrat_regular.montserrat_regular)
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            ProfileItemCard(title = "Edit Profile Details") {}
            ProfileItemCard(title = "Add/Update Address") {}
            ProfileItemCard(title = "Logout") {}
        }
    }
}