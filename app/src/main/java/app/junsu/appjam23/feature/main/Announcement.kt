package app.junsu.appjam23.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Announcement(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val tabNavController = rememberNavController()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            AnnouncementTopBar(
                modifier = Modifier.fillMaxWidth(),
            )
        },
    ) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            AnnouncementTabRow(
                navController = tabNavController,
            )
            NavHost(
                navController = tabNavController,
                startDestination = AnnouncementSections.ALL.route,
            ) {
                composable(AnnouncementSections.ALL.route) {

                }
                composable(AnnouncementSections.NaturalDisaster.route) {

                }
                composable(AnnouncementSections.SocialDisaster.route) {

                }
                composable(AnnouncementSections.EmergencyDisaster.route) {

                }
            }
        }
    }
}

enum class AnnouncementSections(
    val route: String,
) {
    ALL(
        route = "all",
    ),

    NaturalDisaster(
        route = "naturalDisaster",
    ),

    SocialDisaster(
        route = "socialDisaster",
    ),

    EmergencyDisaster(
        route = "emergencyDisaster",
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnnouncementTopBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            Text(
                text = "안내 문자",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    )
}

@Composable
fun AnnouncementTabRow(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    var tabIndex by remember { mutableStateOf(0) }

    TabRow(
        modifier = modifier.fillMaxWidth(),
        selectedTabIndex = tabIndex,
    ) {
        AnnouncementSections.values().forEachIndexed { index, section ->
            val selected = section.route == currentRoute
            Tab(
                selected = selected,
                onClick = {
                    navController.navigateTo(section.route)
                    tabIndex = index
                },
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 12.dp),
                    text = when (section) {
                        AnnouncementSections.ALL -> "전체"
                        AnnouncementSections.NaturalDisaster -> "자연재난"
                        AnnouncementSections.SocialDisaster -> "사회재난"
                        AnnouncementSections.EmergencyDisaster -> "긴급재난"
                    },
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

fun NavHostController.navigateTo(
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
