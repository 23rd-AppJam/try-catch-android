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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import app.junsu.appjam23.R
import app.junsu.appjam23.ui.HumanInformation
import app.junsu.appjam23.ui.HumanInformationItem
import app.junsu.appjam23.ui.HumanInformationType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Nearby(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val tabNavController = rememberNavController()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            NearbyTopBar(
                modifier = Modifier.fillMaxWidth(),
            )
        },
    ) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            NearbyTabRow(
                navController = tabNavController,
            )
            NavHost(
                navController = tabNavController,
                startDestination = NearbySections.MISSING.route,
            ) {
                composable(NearbySections.MISSING.route) {
                    Missing(
                        modifier = Modifier.fillMaxSize(),
                    )
                }
                composable(NearbySections.CRIME.route) {
                    Crime(
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NearbyTopBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            Text(
                text = "내 주변",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
    )
}

enum class NearbySections(
    val route: String,
) {
    MISSING(
        route = "missing",
    ),
    CRIME(
        route = "crime",
    ),
}

@Composable
fun NearbyTabRow(
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
        NearbySections.values().forEachIndexed { index, section ->
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
                        NearbySections.MISSING -> "실종"
                        NearbySections.CRIME -> "범죄"
                    },
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

@Composable
private fun Missing(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        HumanInformationItem(
            imageRes = R.drawable.img_dummy_man,
            information = HumanInformation(
                name = "박준수",
                gender = HumanInformation.Gender.MALE,
                age = 18,
            ),
            type = HumanInformationType.MISSING,
            missingPlace = "대덕SW마이스터고등학교",
        )
        HumanInformationItem(
            imageRes = R.drawable.img_dummy_man,
            information = HumanInformation(
                name = "박준수",
                gender = HumanInformation.Gender.MALE,
                age = 18,
            ),
            type = HumanInformationType.MISSING,
            missingPlace = "대덕SW마이스터고등학교",
        )
        HumanInformationItem(
            imageRes = R.drawable.img_dummy_man,
            information = HumanInformation(
                name = "박준수",
                gender = HumanInformation.Gender.MALE,
                age = 18,
            ),
            type = HumanInformationType.MISSING,
            missingPlace = "대덕SW마이스터고등학교",
        )
    }
}

@Composable
private fun Crime(
    modifier: Modifier = Modifier,
) {

}
