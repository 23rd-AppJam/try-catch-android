package app.junsu.appjam23.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.junsu.appjam23.R
import app.junsu.appjam23.util.navigateTo

@Composable
fun BottomNavBar(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    BottomAppBar(
        modifier = modifier.fillMaxWidth(),
    ) {
        MainSections.values().forEach { section ->
            val selected = currentRoute == section.route
            NavigationBarItem(
                selected = selected,
                onClick = {
                    navController.navigateTo(section.route)
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(
                            if (selected) {
                                section.selectedRes
                            } else {
                                section.defaultRes
                            },
                        ),
                        contentDescription = null,
                    )
                }
            )
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

@Preview
@Composable
private fun BottomNavBarPreview() {
    val navController = rememberNavController()
    BottomNavBar(navController = navController)
}
