package app.junsu.appjam23

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.junsu.appjam23.ui.MonthCalendar
import app.junsu.appjam23.ui.theme.Gray200
import app.junsu.appjam23.ui.theme.Green500

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Calendar(
    modifier: Modifier = Modifier,
) {
    var shouldShowBottomSheet by remember { mutableStateOf(false) }
    val (title, onTitleTextChanged) = remember { mutableStateOf("") }
    val (content, onContentChanged) = remember { mutableStateOf("") }


    if (shouldShowBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { shouldShowBottomSheet = false },
        ) {
            Column(
                modifier = Modifier.systemBarsPadding(),
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    text = "일기 작성",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                )
                Spacer(modifier = Modifier.padding(20.dp))
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    value = title,
                    onValueChange = onTitleTextChanged,
                    placeholder = { Text(text = "제목") }
                )
                Spacer(modifier = Modifier.height(20.dp))
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(horizontal = 20.dp),
                    value = content,
                    onValueChange = onContentChanged,
                    placeholder = { Text(text = "내용을 입력하세요") }
                )
                Spacer(modifier = Modifier.height(20.dp))
                Box(
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .clip(RoundedCornerShape(50.dp))
                        .background(Green500)
                        .fillMaxWidth()
                        .clickable { shouldShowBottomSheet = false }
                        .padding(vertical = 12.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "작성완료",
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )
                }
            }
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CalendarTopBar()
        },
        containerColor = Gray200,
    ) { padValues ->
        Column(
            modifier = modifier
                .background(MaterialTheme.colorScheme.surface)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(padValues),
        ) {
            MonthCalendar(
                onShowCalendar = {
                    shouldShowBottomSheet = true
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CalendarTopBar() {
    TopAppBar(
        title = {
            Text(
                text = "캘린더",
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
