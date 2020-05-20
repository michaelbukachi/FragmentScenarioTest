package michaelbukachi.fragmentscenariotest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


class TestFragmentFactory : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (loadFragmentClass(classLoader, className)) {
            PlainFragment::class.java -> {
                PlainFragment {
                    MainViewModelFactory("This is a message")
                }
            }
            else -> super.instantiate(classLoader, className)
        }
    }
}


@RunWith(AndroidJUnit4::class)
class PlainFragmentTest {
    @Test
    fun testTextIsShown() {
        launchFragmentInContainer<PlainFragment>(
            themeResId = R.style.AppTheme,
            factory = TestFragmentFactory()
        )
        onView(withId(R.id.message)).check(matches(withText("This is a message")))
    }
}