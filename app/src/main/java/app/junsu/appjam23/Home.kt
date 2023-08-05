package app.junsu.appjam23

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import app.junsu.appjam23.ui.TodoList
import app.junsu.appjam23.ui.theme.Gray200
import app.junsu.appjam23.ui.theme.Green500

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Home(
    modifier: Modifier = Modifier,
    onTodoDetailClick: (String) -> Unit,
    navigateToMy: () -> Unit,
) {
    var shouldShowBottomSheet by remember { mutableStateOf(false) }

    if (shouldShowBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { shouldShowBottomSheet = false },
        ) {
            HorizontalPager(
                state = rememberPagerState(),
                modifier = Modifier.fillMaxWidth(),
                pageCount = Face.values().size,
            ) { page ->
                Image(
                    painter = painterResource(
                        id = when (page) {
                            0 -> Face.GOOD.drawableRes
                            1 -> Face.HAPPY.drawableRes
                            2 -> Face.UPSET.drawableRes
                            3 -> Face.SAD.drawableRes
                            else -> Face.SAD.drawableRes
                        }
                    ),
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.systemBarsPadding())
        }
    }


    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            HomeTopBar()
        },
        containerColor = Gray200,
    ) { padValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padValues),
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
            /* WeekCalendar(
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(
                         start = 20.dp,
                         end = 20.dp,
                         top = 25.dp,
                     ),
             )*/
            TodoList(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 20.dp,
                    ),
                onTodoDetailClick = onTodoDetailClick,
            )
            Spacer(modifier = Modifier.height(20.dp))
            GoToShop(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                navigateToMy = navigateToMy,
            )
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun GoToShop(
    modifier: Modifier = Modifier,
    navigateToMy: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { navigateToMy() }
            .background(MaterialTheme.colorScheme.surface)
            .padding(
                horizontal = 20.dp,
                vertical = 15.dp,
            ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_store),
            contentDescription = null,
            tint = Green500,
        )
        Text(
            modifier = Modifier.weight(1f),
            text = "상점으로 가기",
            fontWeight = FontWeight.Bold,
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_forward_big),
            contentDescription = null,
            tint = Color.Black,
        )
    }
}

enum class Face(
    @DrawableRes val drawableRes: Int,
) {
    SAD(
        drawableRes = R.drawable.vector_sad,
    ),
    UPSET(
        drawableRes = R.drawable.vector_upset,
    ),
    GOOD(
        drawableRes = R.drawable.vector_good,
    ),
    HAPPY(
        drawableRes = R.drawable.vector_happy,
    ),
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HomeTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "너도",
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
        },
    )
}
