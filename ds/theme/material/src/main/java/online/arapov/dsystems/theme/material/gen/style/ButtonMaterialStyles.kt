package online.arapov.dsystems.theme.material.gen.style

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import online.arapov.dsystems.component.button.ButtonStyle
import online.arapov.dsystems.theme.material.gen.MaterialTheme

interface ButtonMaterialStyles {
    val primary: ButtonStyle
        @Composable
        @ReadOnlyComposable
        get

    val secondary: ButtonStyle
        @Composable
        @ReadOnlyComposable
        get
}

internal val LocalButtonMaterialStyles =
    staticCompositionLocalOf<ButtonMaterialStyles> { DefaultButtonMaterialStyles }

internal object DefaultButtonMaterialStyles : ButtonMaterialStyles {

    override val primary: ButtonStyle
        @Composable
        @ReadOnlyComposable
        get() = ButtonStyle(
            textStyle = TextStyle(
                fontSize = 12.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.W700,
            ),
            backgroundColor = MaterialTheme.colors.blue,
            contentColor = MaterialTheme.colors.white,
            pressedColor = MaterialTheme.colors.white.copy(alpha = 0.24f),
            disabledContentColor = MaterialTheme.colors.gray28,
            disabledBackgroundColor = MaterialTheme.colors.blue.copy(alpha = 0f),
            minHeight = 36.dp,
            minWidth = 64.dp,
            horizontalPadding = 16.dp,
            elevation = 0.dp,
            shape = RoundedCornerShape(3.dp),
            iconPadding = 6.dp,
            iconSize = 22.dp,
        )

    override val secondary: ButtonStyle
        @Composable
        @ReadOnlyComposable
        get() = primary.copy(
            backgroundColor = MaterialTheme.colors.black.copy(alpha = 0f),
            contentColor = MaterialTheme.colors.blue,
            pressedColor = MaterialTheme.colors.blue.copy(alpha = 0.24f),
            disabledContentColor = MaterialTheme.colors.gray28,
            disabledBackgroundColor = MaterialTheme.colors.black.copy(alpha = 0f),
        )
}