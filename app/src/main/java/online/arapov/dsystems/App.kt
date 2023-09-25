package online.arapov.dsystems

import android.app.Application
import online.arapov.dsystems.core.di.ComponentHolder

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        val component = DaggerAppComponent.create()
        component.inject(this)
        ComponentHolder.components.add(component)
    }
}