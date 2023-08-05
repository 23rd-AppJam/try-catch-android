package app.junsu.appjam23

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.unit.dp
import app.junsu.appjam23.ui.theme.Gray200
import app.junsu.appjam23.ui.theme.Green500

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MyAppJam(
    modifier: Modifier = Modifier,
) {
    var shouldShowBottomSheet by remember { mutableStateOf(false) }

    if (shouldShowBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { shouldShowBottomSheet = false },
        ) {
            Column(
                modifier = Modifier.systemBarsPadding(),
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.BottomCenter,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.vector_earth),
                        contentDescription = null,
                    )
                    Image(
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .clickable { shouldShowBottomSheet = true },
                        painter = painterResource(id = R.drawable.vector_before_grow),
                        contentDescription = null,
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                topStart = 8.dp,
                                topEnd = 8.dp,
                            ),
                        )
                        .background(color = Color.White)
                        .padding(top = 20.dp),
                ) {
                    Column {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .clickable { shouldShowBottomSheet = false },
                            painter = painterResource(id = R.drawable.vector_shop_focussed),
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            modifier = Modifier.padding(start = 20.dp),
                            text = "커스터마이징",
                            style = MaterialTheme.typography.titleMedium,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                        )
                        Spacer(modifier = Modifier.padding(16.dp))
                        Text(
                            modifier = Modifier.padding(start = 20.dp),

                            text = "의상",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Green500,
                        )
                        Spacer(modifier = Modifier.padding(20.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(20.dp)
                        ) {
                            Spacer(modifier = Modifier.padding(20.dp))
                            Image(
                                painter = painterResource(id = R.drawable.img_cloths_1),
                                contentDescription = null,
                            )
                            Image(
                                painter = painterResource(id = R.drawable.img_cloths_2),
                                contentDescription = null,
                            )
                            Image(
                                painter = painterResource(id = R.drawable.img_cloths_3),
                                contentDescription = null,
                            )
                            Image(
                                painter = painterResource(id = R.drawable.img_cloths_4),
                                contentDescription = null,
                            )
                            Spacer(modifier = Modifier.padding(20.dp))
                        }
                        Spacer(modifier = Modifier.padding(20.dp))
                    }
                }
            }
        }
    }

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
                    .clickable { shouldShowBottomSheet = true }
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
        actions = {
            Text(
                text = "1000P",
                fontWeight = FontWeight.Bold,
            )
            Spacer(
                modifier = Modifier.width(16.dp),
            )
        }
    )
}
