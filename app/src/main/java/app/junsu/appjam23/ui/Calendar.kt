package app.junsu.appjam23.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.junsu.appjam23.R
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun WeekCalendar(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(20.dp),
    ) {
        Text(
            text = "2023년 8월 6일",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            DayOfWeek.values().forEachIndexed { index, dayOfWeek ->
                WeekCalendarDate(
                    modifier = Modifier.weight(1f),
                    dayOfWeek = dayOfWeek,
                    date = if (index == 0) 31 else index,
                )
            }
        }
    }
}

@Composable
private fun WeekCalendarDate(
    modifier: Modifier = Modifier,
    dayOfWeek: DayOfWeek,
    date: Int,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.KOREA),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline,
        )

        Text(
            text = date.toString(),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
fun MonthCalendar(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                space = 10.dp,
                Alignment.CenterHorizontally,
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_arrow_forward),
                contentDescription = "forward",
                tint = Color.Black,
            )

            Text(
                text = "8월",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
            )

            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(id = R.drawable.ic_arrow_backward),
                contentDescription = "backward",
                tint = Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(1.dp))
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = "월",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
            )
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = "화",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
            )
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = "수",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
            )
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = "목",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
            )
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = "금",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
            )
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = "토",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
            )
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = "일",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
            )
            Spacer(modifier = Modifier.width(1.dp))
        }
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 31,
                type = null,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 1,
                type = CalendarIconType.SAD,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 2,
                type = CalendarIconType.GOOD,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 3,
                type = CalendarIconType.CRY,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 4,
                type = CalendarIconType.GOOD,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 5,
                type = CalendarIconType.UPSET,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 6,
                type = CalendarIconType.UPSET,
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 7,
                type = CalendarIconType.CRY,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 8,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 9,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 10,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 11,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 12,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 13,
                type = CalendarIconType.BLANK,
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 14,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 15,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 16,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 17,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 18,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 19,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 20,
                type = CalendarIconType.BLANK,
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 21,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 22,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 23,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 24,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 25,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 26,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 27,
                type = CalendarIconType.BLANK,
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 28,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 29,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 30,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 31,
                type = CalendarIconType.BLANK,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 1,
                type = null,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 2,
                type = null,
            )
            MonthlyCalendarItem(
                modifier = Modifier.weight(1f),
                date = 3,
                type = null,
            )
        }
    }
}

@Composable
private fun MonthlyCalendarItem(
    modifier: Modifier = Modifier,
    date: Int,
    type: CalendarIconType?,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        if (type != null) {
            Spacer(modifier = Modifier.height(4.dp))
            Icon(
                painter = painterResource(id = type.resId),
                contentDescription = null,
                tint = Color.Unspecified,
            )
            Text(
                text = date.toString(),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

enum class CalendarIconType(
    @DrawableRes val resId: Int,
) {
    BLANK(
        resId = R.drawable.ic_neo_blank,
    ),
    HAPPY(
        resId = R.drawable.ic_neo_happy,
    ),
    UPSET(
        resId = R.drawable.ic_neo_upset,
    ),
    SAD(
        resId = R.drawable.ic_neo_sad,
    ),
    GOOD(
        resId = R.drawable.ic_neo_good,
    ),
    CRY(
        resId = R.drawable.ic_neo_cry,
    ),
}

@Preview
@Composable
private fun WeekCalendarPreview() {
    WeekCalendar(
        modifier = Modifier.padding(horizontal = 16.dp),
    )
}

@Preview
@Composable
private fun MonthCalendarPreview() {
    MonthCalendar(
        modifier = Modifier.padding(horizontal = 16.dp),
    )
}
