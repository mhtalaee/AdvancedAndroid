package ir.goldenmind.advancedandroid;

import androidx.test.espresso.action.ViewActions;
import ir.goldenmind.advancedandroid.kotlinversion.activities.MainActivity;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import ir.goldenmind.advancedandroid.javaversion.activities.TestUiActivity;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UiTest {

    private Integer inputNumber;

    @Rule
    public ActivityTestRule<TestUiActivity> activityRule = new ActivityTestRule<>(TestUiActivity.class);

    @Before
    public void initValidString() {
        inputNumber = 1;
    }

    @Test
    public void changeText_sameActivity() {

       onView(withId(R.id.etNumber)).perform(typeText(inputNumber.toString()), ViewActions.closeSoftKeyboard());
       onView(withId(R.id.btnOk)).perform(click());
       onView(withId(R.id.imgOdd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}
