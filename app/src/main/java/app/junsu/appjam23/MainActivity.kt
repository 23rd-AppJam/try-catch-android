package app.junsu.appjam23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.junsu.appjam23.ui.BottomNavBar
import app.junsu.appjam23.ui.theme.Appjam23Theme
import app.junsu.appjam23.ui.theme.Gray200
import app.junsu.appjam23.ui.theme.Green500

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

    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 30.dp,
                            bottomEnd = 30.dp,
                        ),
                    )
                    .background(Green500),
            )
            Scaffold(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.6f),
                bottomBar = {
                    BottomNavBar(navController = bottomNavController)
                },
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

                    }

                    composable(MainSections.MY_APPJAM.route) {

                    }
                }
            }
        }
    }
}

enum class MainSections(
    val route: String,
    @DrawableRes val defaultRes: Int,
    @DrawableRes val selectedRes: Int,
) {
    CALENDAR(
        route = "calendar",
        defaultRes = R.drawable.ic_calendar_default,
        selectedRes = R.drawable.ic_calendar_selected,
    ),
    HOME(
        route = "home",
        defaultRes = R.drawable.ic_home_default,
        selectedRes = R.drawable.ic_home_selected,
    ),
    MY_APPJAM(
        route = "myAppJam",
        defaultRes = R.drawable.ic_my_default,
        selectedRes = R.drawable.ic_my_selected,
    ),
}
