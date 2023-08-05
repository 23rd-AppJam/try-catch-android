package app.junsu.appjam23.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.junsu.appjam23.R
import app.junsu.appjam23.ui.theme.Gray500
import app.junsu.appjam23.ui.theme.Green500

@Composable
fun TodoList(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ) {
        Text(
            text = "오늘 할 일",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(15.dp))
        TodoItem(
            modifier = Modifier.fillMaxWidth(),
            title = "식물에 물 주기",
        )
        TodoItem(
            modifier = Modifier.fillMaxWidth(),
            title = "걷기",
        )
        TodoItem(
            modifier = Modifier.fillMaxWidth(),
            title = "식물에 물 주기",
        )
    }
}

@Composable
private fun TodoItem(
    modifier: Modifier = Modifier,
    title: String,
) {
    var checked by remember { mutableStateOf(false) }

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    checked = !checked
                },
            painter = painterResource(id = R.drawable.ic_check),
            contentDescription = "check",
            tint = if (checked) {
                Green500
            } else {
                Gray500
            },
        )
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            style = MaterialTheme.typography.bodyLarge,
        )
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = "more",
            tint = Gray500,
        )
    }
}

@Preview
@Composable
private fun TodoListPreview() {
    TodoList(
        modifier = Modifier.padding(horizontal = 16.dp),
    )
}
