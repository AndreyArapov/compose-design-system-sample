package online.arapov.dsystems

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import online.arapov.dsystems.component.button.Button
import online.arapov.dsystems.component.promo_block.PromoBlock
import online.arapov.dsystems.core.ui.Icon
import online.arapov.dsystems.core.ui.Text
import online.arapov.dsystems.theme.alnf.AlnfTheme
import online.arapov.dsystems.theme.alnf.gen.AlnfTheme
import online.arapov.dsystems.theme.material.MaterialTheme
import online.arapov.dsystems.theme.material.gen.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Screen()
        }
    }
}

@Composable
fun Screen() {
    var isDark by remember { mutableStateOf(false) }
    var isCompat by remember { mutableStateOf(false) }
    var isMaterial by remember { mutableStateOf(false) }

    if (isMaterial) {
        MaterialTheme(
            isDark = isDark,
            isCompatModeEnabled = isCompat
        ) {
            Content(
                isDark = isDark,
                darkModeChange = { isDark = !isDark },
                isCompat = isCompat,
                compatModeChange = { isCompat = !isCompat },
                isMaterial = isMaterial,
                themeChange = { isMaterial = !isMaterial }
            )
        }
    } else {
        AlnfTheme(
            isDark = isDark
        ) {
            Content(
                isDark = isDark,
                darkModeChange = { isDark = !isDark },
                isCompat = isCompat,
                compatModeChange = { isCompat = !isCompat },
                isMaterial = isMaterial,
                themeChange = { isMaterial = !isMaterial }
            )
        }
    }
}

@Composable
fun Content(
    isDark: Boolean = false,
    darkModeChange: () -> Unit = {},
    isCompat: Boolean = false,
    compatModeChange: () -> Unit = {},
    isMaterial: Boolean = false,
    themeChange: () -> Unit = {}
) {
    val image = ImageVector.vectorResource(id = R.drawable.ic_android_black_24dp)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val buttonStyle = if (isMaterial)
                MaterialTheme.buttonStyles.primary
            else
                AlnfTheme.buttonStyles.primary
            Button(
                title = if (isMaterial) "Material Theme" else "Alnf Theme",
                onClick = themeChange,
                style = buttonStyle
            )
            Button(
                title = if (isDark) "Dark Theme" else "Light Theme",
                onClick = darkModeChange,
                style = buttonStyle
            )
            if (isMaterial) {
                Button(
                    title = if (isCompat) "Compat Enabled" else "Compat Disabled",
                    onClick = compatModeChange,
                    style = buttonStyle
                )
            }
        }
        Text(
            text = stringResource(id = R.string.lorem_ipsum),
            style = TextStyle.Default
        )
        Text(
            text = "Buttons:",
            modifier = Modifier.padding(top = 8.dp),
            style = TextStyle(
                fontWeight = FontWeight.Bold
            )
        )
        Buttons(image, isMaterial)
        val promoBlockStyle = if (isMaterial)
            MaterialTheme.promoBlockStyles.blue
        else
            AlnfTheme.promoBlockStyles.blue

        PromoBlock(
            modifier = Modifier
                .fillMaxWidth(),
            style = promoBlockStyle
        ) {
            Column(
                modifier = Modifier.padding(
                    top = 16.dp,
                    bottom = 16.dp
                ),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Buttons(image, isMaterial)
            }
        }
    }
}

@Composable
private fun Buttons(
    image: ImageVector,
    isMaterial: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val buttonStyle = if (isMaterial)
            MaterialTheme.buttonStyles.primary
        else
            AlnfTheme.buttonStyles.primary
        Button(
            title = "Primary",
            onClick = {},
            style = buttonStyle
        )
        Button(
            title = "Icon",
            onClick = {},
            iconLeft = {
                val painter = rememberVectorPainter(image = image)
                Icon(
                    painter = painter
                )
            },
            style = buttonStyle
        )
        Button(
            title = "Disabled",
            onClick = {},
            enabled = false,
            style = buttonStyle
        )
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        val buttonStyle = if (isMaterial)
            MaterialTheme.buttonStyles.secondary
        else
            AlnfTheme.buttonStyles.secondary
        Button(
            title = "Secondary",
            style = buttonStyle,
            onClick = {}
        )
        Button(
            title = "Icon",
            onClick = {},
            style = buttonStyle,
            iconLeft = {
                val painter = rememberVectorPainter(image = image)
                Icon(
                    painter = painter
                )
            }
        )
        Button(
            title = "Disabled",
            onClick = {},
            style = buttonStyle,
            enabled = false
        )
    }
}


@Preview(
    name = "Screen",
    showBackground = true,
    device = Devices.PIXEL_4
)
@Composable
fun ScreenPreview() {
    Screen()
}

@Preview(
    name = "Material",
    showBackground = true,
    device = Devices.PIXEL_4
)
@Preview(
    name = "Material Night",
    showBackground = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun MaterialPreview() {
    MaterialTheme {
        Content(
            isMaterial = true
        )
    }
}

@Preview(
    name = "Alnf",
    showBackground = true,
    device = Devices.PIXEL_4
)
@Preview(
    name = "Alnf",
    showBackground = true,
    device = Devices.PIXEL_4,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun AlnfPreview() {
    AlnfTheme {
        Content(
            isMaterial = false
        )
    }
}