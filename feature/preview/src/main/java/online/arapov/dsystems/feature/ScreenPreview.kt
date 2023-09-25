package online.arapov.dsystems.feature

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import online.arapov.dsystems.component.button.ButtonImpl
import online.arapov.dsystems.component.promo_block.PromoBlockImpl
import online.arapov.dsystems.theme.alnf.AlnfTheme
import online.arapov.dsystems.theme.material.MaterialTheme

@Preview(
    name = "Screen",
    showBackground = true,
    device = Devices.PIXEL_4
)
@Composable
private fun ScreenPreview() {
    AppScreenImpl(ButtonImpl(), PromoBlockImpl()).invoke()
}

@Preview(
    name = "Material",
    showBackground = true,
    device = Devices.PIXEL_4
)
@Composable
private fun MaterialPreview() {
    MaterialTheme {
        Content(ButtonImpl(), PromoBlockImpl())
    }
}

@Preview(
    name = "Alnf",
    showBackground = true,
    device = Devices.PIXEL_4
)
@Composable
private fun AlnfPreview() {
    AlnfTheme {
        Content(ButtonImpl(), PromoBlockImpl())
    }
}