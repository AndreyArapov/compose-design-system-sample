package online.arapov.dsystems.component.promo_block

import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

interface PromoBlock {

    @Composable
    operator fun invoke(
        style: PromoBlockStyle,
        modifier: Modifier = Modifier,
        content: @Composable BoxScope.() -> Unit
    ) = Block(
        style, modifier, content
    )

    @Composable
    fun Block(
        style: PromoBlockStyle,
        modifier: Modifier,
        content: @Composable BoxScope.() -> Unit
    )
}