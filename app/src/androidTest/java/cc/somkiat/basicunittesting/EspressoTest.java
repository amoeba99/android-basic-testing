package cc.somkiat.basicunittesting;

import android.os.SystemClock;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Amoeba on 11/15/2017.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class EspressoTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void start(){
        closeSoftKeyboard();
    }

    @Test
    public void emptyName(){
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText(""));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("346@starlight.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(allOf(withId(android.R.id.message), withText("Name is empty please enter name"), isDisplayed()));
        SystemClock.sleep(1000);
        onView(allOf(withId(android.R.id.button1))).perform(scrollTo(), click());
    }

    @Test
    public void nameIncorrectFormat(){
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("Viriya99"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("346@starlight.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(allOf(withId(android.R.id.message), withText("Name is Incorrect format"), isDisplayed()));
        SystemClock.sleep(1000);
        onView(allOf(withId(android.R.id.button1))).perform(click());
    }

    @Test
    public void emptyEmail(){
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("Viriya"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(allOf(withId(android.R.id.message), withText("Email is empty"), isDisplayed()));
        SystemClock.sleep(1000);
        onView(allOf(withId(android.R.id.button1))).perform(click());
    }

    @Test
    public void emailIncorrectFormat(){
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("Viriya"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("346.765"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(allOf(withId(android.R.id.message), withText("Email is incorrect"), isDisplayed()));
        SystemClock.sleep(1000);
        onView(allOf(withId(android.R.id.button1))).perform(click());
    }

    @Test
    public void Success(){
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("Viriya"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("346@starlight.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(allOf(withId(android.R.id.message), withText("Save Success"), isDisplayed()));
        SystemClock.sleep(1000);
        onView(allOf(withId(android.R.id.button1))).perform(click());
    }

}
