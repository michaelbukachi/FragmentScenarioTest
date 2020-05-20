package michaelbukachi.fragmentscenariotest.dagger

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import javax.inject.Provider

class InjectFragmentFactory(
    private val providers: Map<String, Provider<Fragment>>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return providers[className]?.get() ?: super.instantiate(classLoader, className)
    }

    companion object {

        operator fun invoke(
            providers: Map<Class<out Fragment>, Provider<Fragment>>
        ) : InjectFragmentFactory {
            return InjectFragmentFactory(
                providers.mapKeys { (fragmentClass, _) -> fragmentClass.name }
            )
        }
    }
}

abstract class EmptyActivityLifecycleCallbacks  : Application.ActivityLifecycleCallbacks {
    override fun onActivityPaused(activity: Activity) {}
    override fun onActivityStarted(activity: Activity) {}
    override fun onActivityDestroyed(activity: Activity) {}
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
    override fun onActivityStopped(activity: Activity) {}
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}
    override fun onActivityResumed(activity: Activity) {}
}

class SetFragmentFactoryActivityCallback(
    private val newFragmentFactory: FragmentFactory
) : EmptyActivityLifecycleCallbacks() {

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        if (activity is FragmentActivity) {
            activity.supportFragmentManager.fragmentFactory = newFragmentFactory
        }
    }
}