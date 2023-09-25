package online.arapov.dsystems.component.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import online.arapov.dsystems.theme.alnf.AlnfTheme
import online.arapov.dsystems.theme.alnf.gen.AlnfTheme
import online.arapov.dsystems.theme.material.MaterialTheme
import online.arapov.dsystems.theme.material.gen.MaterialTheme


@Composable
@Preview("Material")
private fun ButtonPreview() {
    MaterialTheme {
        val buttonImpl = ButtonImpl()
        buttonImpl.Button(
            title = "Button",
            style = MaterialTheme.buttonStyles.primary
        )
    }
}

@Composable
@Preview("Alnf")
private fun ButtonAlnfPreview() {
    AlnfTheme {
        val buttonImpl = ButtonImpl()
        buttonImpl.Button(
            title = "Button",
            style = AlnfTheme.buttonStyles.primary
        )
    }
}