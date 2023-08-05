package app.junsu.appjam23.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.junsu.appjam23.MainSections
import app.junsu.appjam23.ui.theme.Gray500
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
                        painter = painterResource(section.defaultRes),
                        contentDescription = null,
                        tint = if (selected) {
                            Color.Black
                        } else {
                            Gray500
                        },
                    )
                },
                label = {
                    Text(
                        text = when (section) {
                            MainSections.CALENDAR -> "캘린더"
                            MainSections.HOME -> "홈"
                            MainSections.MY_APPJAM -> "My 앱잼"
                        },
                        color = if (selected) {
                            Color.Black
                        } else {
                            Gray500
                        },
                    )
                },
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavBarPreview() {
    val navController = rememberNavController()
    BottomNavBar(navController = navController)
}
