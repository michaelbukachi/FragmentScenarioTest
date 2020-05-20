package michaelbukachi.fragmentscenariotest

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class KoinFragmentTest {
    @Test
    fun testTextIsShown() {
        launchFragmentInContainer<KoinFragment>(
            themeResId = R.style.AppTheme
        )
        onView(withId(R.id.message)).check(matches(withText("This is a message")))
    }
}