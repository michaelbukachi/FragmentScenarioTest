package michaelbukachi.fragmentscenariotest.dagger

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import michaelbukachi.fragmentscenariotest.DaggerFragment

@Module
interface FragmentBindsModule {

    @Binds
    @IntoMap
    @FragmentKey(DaggerFragment::class)
    fun bindDaggerFragmentToFragmentForMultiBinding(fragment: DaggerFragment): Fragment
}