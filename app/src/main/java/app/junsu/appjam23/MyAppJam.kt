package app.junsu.appjam23

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.junsu.appjam23.ui.theme.Gray200

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyAppJam(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            MyAppJamTopBar()
        },
        containerColor = Gray200,
    ) { padValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(padValues),
        ) {
            HorizontalPager(
                modifier = Modifier.weight(1f),
                pageCount = 3,
            ) { page ->
                when (page) {
                    0 -> {
                        Column {
                            Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                modifier = Modifier.weight(1f),
                            ) {
                                Image(
                                    modifier = Modifier.weight(1f),
                                    painter = painterResource(id = R.drawable.img_dummy_1),
                                    contentDescription = null,
                                )
                                Image(
                                    modifier = Modifier.weight(1f),
                                    painter = painterResource(id = R.drawable.img_dummy_2),
                                    contentDescription = null,
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                modifier = Modifier.weight(1f),
                            ) {
                                Image(
                                    modifier = Modifier.weight(1f),
                                    painter = painterResource(id = R.drawable.img_dummy_3),
                                    contentDescription = null,
                                )
                                Image(
                                    modifier = Modifier.weight(1f),
                                    painter = painterResource(id = R.drawable.img_dummy_4),
                                    contentDescription = null,
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }

                    1 -> {
                        Column {
                            Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                modifier = Modifier.weight(1f),
                            ) {
                                Image(
                                    modifier = Modifier.weight(1f),
                                    painter = painterResource(id = R.drawable.img_dummy_1),
                                    contentDescription = null,
                                )
                                Image(
                                    modifier = Modifier.weight(1f),
                                    painter = painterResource(id = R.drawable.img_dummy_2),
                                    contentDescription = null,
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                modifier = Modifier.weight(1f),
                            ) {
                                Image(
                                    modifier = Modifier.weight(1f),
                                    painter = painterResource(id = R.drawable.img_dummy_3),
                                    contentDescription = null,
                                )
                                Image(
                                    modifier = Modifier.weight(1f),
                                    painter = painterResource(id = R.drawable.img_dummy_4),
                                    contentDescription = null,
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }

                    2 -> {
                        Column {
                            Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                modifier = Modifier.weight(1f),
                            ) {
                                Image(
                                    modifier = Modifier.weight(1f),
                                    painter = painterResource(id = R.drawable.img_dummy_1),
                                    contentDescription = null,
                                )
                                Image(
                                    modifier = Modifier.weight(1f),
                                    painter = painterResource(id = R.drawable.img_dummy_2),
                                    contentDescription = null,
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))
                            Row(
                                modifier = Modifier.weight(1f),
                            ) {
                                Image(
                                    modifier = Modifier.weight(1f),
                                    painter = painterResource(id = R.drawable.img_dummy_3),
                                    contentDescription = null,
                                )
                                Image(
                                    modifier = Modifier.weight(1f),
                                    painter = painterResource(id = R.drawable.img_dummy_4),
                                    contentDescription = null,
                                )
                            }

                            Spacer(modifier = Modifier.height(20.dp))
                        }
                    }
                }
            }
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                painter = painterResource(id = R.drawable.vector_forest_focussed),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MyAppJamTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "My 너도",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
            )
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Transparent,
        ),
    )
}
