package app.junsu.appjam23.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import app.junsu.appjam23.ui.theme.Blue500

@Composable
fun HumanInformationItem(
    modifier: Modifier = Modifier,
    @DrawableRes imageRes: Int,
    information: HumanInformation,
    type: HumanInformationType,
    missingPlace: String? = null,
    crimeName: String? = null,
    characteristic: List<String> = emptyList(),
) {
    when (type) {
        HumanInformationType.MISSING -> requireNotNull(missingPlace)
        HumanInformationType.CRIME -> requireNotNull(crimeName)
    }
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row {
            Image(
                modifier = Modifier
                    .padding(
                        horizontal = 20.dp,
                        vertical = 15.dp,
                    )
                    .size(72.dp),
                painter = painterResource(imageRes),
                contentDescription = null,
            )
            Column {
                Spacer(
                    modifier = Modifier.height(15.dp),
                )
                Row(
                    verticalAlignment = Alignment.Bottom,
                ) {
                    Text(
                        text = information.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Blue500,
                    )
                    Spacer(
                        modifier = Modifier.width(2.dp),
                    )
                    Text(
                        text = missingPlace ?: crimeName!!,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.outline,
                    )
                }
                Spacer(
                    modifier = Modifier.height(10.dp),
                )
                Text(
                    text = "${
                        when (information.gender) {
                            HumanInformation.Gender.MALE -> "남"
                            HumanInformation.Gender.FEMALE -> "여"
                        }
                    }, ${information.age}세\n$characteristic",
                    style = MaterialTheme.typography.bodyMedium,
                )
                Spacer(
                    modifier = Modifier.height(15.dp),
                )
            }
        }
        Divider()
    }
}

enum class HumanInformationType {
    MISSING, CRIME,
}

class HumanInformation(
    val name: String,
    val gender: Gender,
    val age: Int,
) {
    enum class Gender {
        MALE, FEMALE,
    }
}
