package michaelbukachi.fragmentscenariotest

import android.app.Application
import michaelbukachi.fragmentscenariotest.dagger.DaggerApplicationComponent
import michaelbukachi.fragmentscenariotest.dagger.Injector
import michaelbukachi.fragmentscenariotest.dagger.SetFragmentFactoryActivityCallback
import michaelbukachi.fragmentscenariotest.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FragmentScenarioTest: Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.initialize(DaggerApplicationComponent.factory().create(this))
        registerActivityLifecycleCallbacks(SetFragmentFactoryActivityCallback(Injector.get().fragmentFactory))

        startKoin{
            androidLogger()
            androidContext(this@FragmentScenarioTest)
            modules(appModule)
        }
    }
}