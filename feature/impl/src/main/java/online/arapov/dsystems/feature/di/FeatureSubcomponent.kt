package online.arapov.dsystems.feature.di

import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo
import online.arapov.dsystems.core.di.AppScope
import online.arapov.dsystems.feature.MainActivity

@ContributesSubcomponent(MainScope::class, AppScope::class)
interface FeatureSubcomponent {

    fun inject(activity: MainActivity)

    @ContributesTo(AppScope::class)
    interface ParentComponent {
        fun createFeatureSubcomponent(): FeatureSubcomponent
    }
}