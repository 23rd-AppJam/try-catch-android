package app.junsu.appjam23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.junsu.appjam23.ui.BottomNavBar
import app.junsu.appjam23.ui.theme.Appjam23Theme
import app.junsu.appjam23.ui.theme.Gray200
import app.junsu.appjam23.ui.theme.Gray800
import app.junsu.appjam23.ui.theme.Green50
import app.junsu.appjam23.ui.theme.Red50
import app.junsu.appjam23.util.navigateTo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Appjam23Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Gray200,
                ) {
                    AppJam23App()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppJam23App() {
    val bottomNavController = rememberNavController()
    var modalBottomSheet by remember { mutableStateOf(false) }
    var selectedTodoTitle by remember { mutableStateOf("") }
    val onShowModal = { title: String ->
        selectedTodoTitle = title
        modalBottomSheet = true
    }

    LaunchedEffect(Unit) {
        bottomNavController.navigateTo(MainSections.HOME.route)
    }

    if (modalBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { modalBottomSheet = false },
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = selectedTodoTitle,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                ) {
                    OptionButton(
                        modifier = Modifier.weight(
                            weight = 1f,
                        ),
                        onClick = { /*TODO*/ },
                        iconRes = R.drawable.ic_edit,
                        text = "수정하기",
                        backgroundColor = Green50,
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    OptionButton(
                        modifier = Modifier.weight(
                            weight = 1f,
                        ),
                        onClick = { /*TODO*/ },
                        iconRes = R.drawable.ic_delete,
                        text = "삭제하기",
                        backgroundColor = Red50,
                    )
                }
                Spacer(modifier = Modifier.systemBarsPadding())
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomNavBar(navController = bottomNavController)
        },
        containerColor = Color.Transparent,
    ) { padValues ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(padValues),
            navController = bottomNavController,
            startDestination = MainSections.CALENDAR.route,
        ) {
            composable(MainSections.CALENDAR.route) {
                Calendar()
            }

            composable(MainSections.HOME.route) {
                Home(
                    onTodoDetailClick = onShowModal,
                )
            }

            composable(MainSections.MY_APPJAM.route) {

            }
        }
    }
}

enum class MainSections(
    val route: String,
    @DrawableRes val defaultRes: Int,
) {
    CALENDAR(
        route = "calendar",
        defaultRes = R.drawable.ic_calendar_selected,
    ),
    HOME(
        route = "home",
        defaultRes = R.drawable.ic_home_selected,
    ),
    MY_APPJAM(
        route = "myAppJam",
        defaultRes = R.drawable.ic_my,
    ),
}

@Composable
private fun OptionButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    @DrawableRes iconRes: Int,
    text: String,
    backgroundColor: Color,
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .background(backgroundColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Spacer(
            modifier = Modifier.height(10.dp),
        )
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            tint = Gray800,
        )
        Text(
            text = text,
            color = Gray800,
            style = MaterialTheme.typography.bodyMedium,
        )
        Spacer(
            modifier = Modifier.height(10.dp),
        )
    }
}
