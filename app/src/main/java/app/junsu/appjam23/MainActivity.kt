package app.junsu.appjam23

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.junsu.appjam23.feature.main.All
import app.junsu.appjam23.feature.main.Announcement
import app.junsu.appjam23.feature.main.Home
import app.junsu.appjam23.feature.main.Nearby
import app.junsu.appjam23.ui.theme.Blue500
import app.junsu.appjam23.ui.theme.Gray500
import app.junsu.appjam23.ui.theme._23rdAppJamTheme
import app.junsu.appjam23.util.sendNotification
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.Default).launch {
            delay(3000L)
            sendNotification(
                "TEST",
                "CONTENT TEST",
            )
        }
        setContent {
            _23rdAppJamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    TryCatchApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TryCatchApp() {
    val navController = rememberNavController()
    val bottomNavController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            TryCatchBottomBar(
                modifier = Modifier.fillMaxWidth(),
                navController = bottomNavController,
            )
        },
    ) { paddingValues ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
                    end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
                ),
            navController = bottomNavController,
            startDestination = MainSections.HOME.route,
        ) {
            composable(MainSections.HOME.route) {
                Home(
                    modifier = Modifier.fillMaxSize(),
                    navController = navController,
                )
            }
            composable(MainSections.ANNOUNCEMENT.route) {
                Announcement(
                    modifier = Modifier.fillMaxWidth(),
                    navController = navController,
                )
            }
            composable(MainSections.NEARBY.route) {
                Nearby()
            }
            composable(MainSections.ALL.route) {
                All()
            }
        }
    }
}

@Composable
fun TryCatchBottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedBottomBarItem = navBackStackEntry?.destination?.route
    BottomAppBar(
        modifier = modifier
            .fillMaxWidth()
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                )
                shadowElevation = 20f
            },
        containerColor = MaterialTheme.colorScheme.background,
    ) {
        MainSections.values().forEach { section ->
            val selected = section.route == selectedBottomBarItem
            val selectedColor = if (selected) {
                Blue500
            } else {
                Gray500
            }

            NavigationBarItem(
                selected = selected,
                onClick = { navController.navigateTo(section.route) },
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(
                            if (selected) {
                                section.selectedIconRes
                            } else {
                                section.defaultIconRes
                            },
                        ),
                        contentDescription = section.route,
                        tint = selectedColor,
                    )
                },
                label = {
                    Text(
                        text = when (section) {
                            MainSections.HOME -> "홈"
                            MainSections.ANNOUNCEMENT -> "안내 문자"
                            MainSections.NEARBY -> "내 주변"
                            MainSections.ALL -> "전체"
                        },
                        color = selectedColor,
                    )
                },
            )
        }
    }
}

private fun NavHostController.navigateTo(
    route: String,
) {
    this.navigate(route) {
        popUpTo(this@navigateTo.graph.findStartDestination().id) {
            saveState = true
        }

        launchSingleTop = true
        restoreState = true
    }
}

enum class MainSections(
    val route: String,
    @DrawableRes val defaultIconRes: Int,
    @DrawableRes val selectedIconRes: Int,
) {
    HOME(
        route = "HOME",
        defaultIconRes = R.drawable.ic_home_default,
        selectedIconRes = R.drawable.ic_home_selected,
    ),

    ANNOUNCEMENT(
        route = "ANNOUNCEMENT",
        defaultIconRes = R.drawable.ic_announcement_default,
        selectedIconRes = R.drawable.ic_announcement_selected,
    ),

    NEARBY(
        route = "NEARBY",
        defaultIconRes = R.drawable.ic_nearby_default,
        selectedIconRes = R.drawable.ic_nearby_selected,
    ),

    ALL(
        route = "ALL",
        defaultIconRes = R.drawable.ic_all_default,
        selectedIconRes = R.drawable.ic_all_selected,
    ),
}

@Composable
fun TryCatchTabRow(
    modifier: Modifier = Modifier,
) {
    TabRow(
        modifier = modifier.fillMaxWidth(),
        selectedTabIndex = 0,
    ) {
        Tab(selected = true, onClick = { /*TODO*/ }) {
            Text(text = "재해")
        }

        Tab(selected = true, onClick = { /*TODO*/ }) {
            Text(text = "ㅁㄴㅇㄹ")
        }

        Tab(selected = true, onClick = { /*TODO*/ }) {
            Text(text = "asdfaf")
        }
    }
}
