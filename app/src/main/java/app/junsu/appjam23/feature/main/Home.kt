package app.junsu.appjam23.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import app.junsu.appjam23.TryCatchTabRow
import app.junsu.appjam23.TryCatchTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TryCatchTopBar(
                modifier = Modifier.fillMaxWidth(),
                onNavigationIconClick = navController::navigateUp,
            )
        },
    ) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            TryCatchTabRow()
        }
    }
} 
