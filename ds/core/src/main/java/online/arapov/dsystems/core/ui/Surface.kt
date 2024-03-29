package online.arapov.dsystems.core.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Surface(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(5.dp),
    elevation: Dp = 0.dp,
    color: Color = Color.Transparent,
    border: BorderStroke? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication? = LocalIndication.current,
    enabled: Boolean = true,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .shadow(elevation, shape, clip = false)
            .then(if (border != null) Modifier.border(border, shape) else Modifier)
            .background(color, shape)
            .then(
                Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = indication,
                    enabled = enabled,
                    role = Role.Button,
                    onClick = onClick
                )
            )
    ) {
        content()
    }
}