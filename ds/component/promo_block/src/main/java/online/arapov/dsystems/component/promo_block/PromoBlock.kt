package online.arapov.dsystems.component.promo_block

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import online.arapov.dsystems.core.DefaultTheme

@Composable
fun PromoBlock(
    style: PromoBlockStyle,
    modifier: Modifier = Modifier,
    content: @Composable BoxScope.() -> Unit
) {
    DefaultTheme(theme = style.theme()) {
        Box(
            modifier = modifier
                .background(style.backgroundColor, style.shape)
                .padding(8.dp),
            content = content
        )
    }
}