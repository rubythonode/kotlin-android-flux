package jp.satorufujiwara.kotlin

import dagger.Component
import jp.satorufujiwara.kotlin.data.DebugDataModule
import jp.satorufujiwara.kotlin.ui.FluxModule

@AppScope
@Component(modules = arrayOf(DebugAppModule::class, DebugDataModule::class, FluxModule::class))
interface AppComponent : MainAppComponent {

    fun inject(app: KotlinApp)

    object Initializer {
        fun init(app: KotlinApp): AppComponent =
                DaggerAppComponent.builder()
                        .debugAppModule(DebugAppModule(app))
                        .debugDataModule(DebugDataModule())
                        .build()
    }
}
