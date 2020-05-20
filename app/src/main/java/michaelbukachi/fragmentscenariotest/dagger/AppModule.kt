package michaelbukachi.fragmentscenariotest.dagger

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
object AppModule {

    @JvmStatic
    @Provides
    fun appContext(app: Application): Context = app

    @JvmStatic
    @Provides
    fun providesMessage(): String = "This is a message"

    @Provides
    fun provideFragmentFactory(
        fragmentProviders: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
    ): FragmentFactory {
        return InjectFragmentFactory(fragmentProviders)
    }

}