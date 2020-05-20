package michaelbukachi.fragmentscenariotest.koin

import michaelbukachi.fragmentscenariotest.MainViewModel3
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { "This is a message" }
    viewModel { MainViewModel3(get()) }
}