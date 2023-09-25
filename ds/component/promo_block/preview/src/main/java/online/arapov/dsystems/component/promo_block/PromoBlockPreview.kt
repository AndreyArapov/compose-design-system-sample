package online.arapov.dsystems.component.promo_block

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import online.arapov.dsystems.component.button.Button
import online.arapov.dsystems.component.button.ButtonImpl
import online.arapov.dsystems.theme.alnf.AlnfTheme
import online.arapov.dsystems.theme.alnf.gen.AlnfTheme
import online.arapov.dsystems.theme.material.MaterialTheme
import online.arapov.dsystems.theme.material.gen.MaterialTheme

@Composable
@Preview("Material")
private fun PromoBlockPreview() {
    MaterialTheme {
        val promoBlockImpl = PromoBlockImpl()
        promoBlockImpl.PromoBlock(style = MaterialTheme.promoBlockStyles.blue) {
            val buttonImpl = ButtonImpl()
            buttonImpl.Button(
                title = "PromoBlock Blue",
                style = MaterialTheme.buttonStyles.primary
            )
        }
    }
}

@Composable
@Preview("Alnf")
private fun PromoBlockAlnfPreview() {
    AlnfTheme {
        val promoBlockImpl = PromoBlockImpl()
        promoBlockImpl.PromoBlock(style = AlnfTheme.promoBlockStyles.blue) {
            val buttonImpl = ButtonImpl()
            buttonImpl.Button(
                title = "PromoBlock Blue",
                style = AlnfTheme.buttonStyles.primary
            )
        }
    }
}