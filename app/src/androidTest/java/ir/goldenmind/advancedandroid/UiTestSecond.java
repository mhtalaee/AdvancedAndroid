package ir.goldenmind.advancedandroid;

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

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class UiTestSecond {

    private Integer inputNumber;

    @Rule
    public ActivityTestRule<TestUiActivity> activityRule = new ActivityTestRule<>(TestUiActivity.class);
    private TestUiActivity testUiActivity = null;

    @Before
    public void initValidString() {
        inputNumber = 1;
        testUiActivity = activityRule.getActivity();
    }

    @Test
    public void changeText_sameActivity() {

        testUiActivity.setImage("1");
        onView(withId(R.id.imgOdd)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}
