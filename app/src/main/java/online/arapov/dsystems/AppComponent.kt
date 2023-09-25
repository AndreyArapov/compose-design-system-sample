package online.arapov.dsystems

import com.squareup.anvil.annotations.MergeComponent
import online.arapov.dsystems.core.di.AppScope
import javax.inject.Singleton

@Singleton
@MergeComponent(AppScope::class)
interface AppComponent {
    fun inject(app: App)
}
