package online.arapov.dsystems.core.di

object ComponentHolder {
    val components = mutableSetOf<Any>()

    inline operator fun <reified T> invoke(): T = components
        .filterIsInstance<T>()
        .single()
}