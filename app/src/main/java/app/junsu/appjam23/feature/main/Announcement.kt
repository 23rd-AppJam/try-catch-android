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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Announcement(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
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
            AnnouncementTabRow()
        }
    }
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
) {
    TabRow(
        modifier = modifier.fillMaxWidth(),
        selectedTabIndex = 0,
    ) {
        Tab(
            selected = true,
            onClick = { /*TODO*/ },
        ) {
            Text(
                modifier = Modifier.padding(vertical = 12.dp),
                text = "전체",
                style = MaterialTheme.typography.bodyMedium,
            )
        }

        Tab(
            selected = true,
            onClick = { /*TODO*/ },
        ) {
            Text(
                modifier = Modifier.padding(vertical = 12.dp),
                text = "자연재난",
                style = MaterialTheme.typography.bodyMedium,
            )
        }

        Tab(
            selected = true,
            onClick = { /*TODO*/ },
        ) {
            Text(
                modifier = Modifier.padding(vertical = 12.dp),
                text = "사회재난",
                style = MaterialTheme.typography.bodyMedium,
            )
        }

        Tab(
            selected = true,
            onClick = { /*TODO*/ },
        ) {
            Text(
                modifier = Modifier.padding(vertical = 12.dp),
                text = "비상재난",
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}
