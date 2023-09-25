package online.arapov.dsystems.feature

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import online.arapov.dsystems.core.di.ComponentHolder
import online.arapov.dsystems.feature.di.FeatureSubcomponent
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var screen: AppScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ComponentHolder<FeatureSubcomponent.ParentComponent>()
            .createFeatureSubcomponent()
            .inject(this)
        setContent {
            screen()
        }
    }
}
