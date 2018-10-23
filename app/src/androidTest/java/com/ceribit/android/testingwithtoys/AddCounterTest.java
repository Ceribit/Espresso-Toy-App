package com.ceribit.android.testingwithtoys;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class AddCounterTest {

    @Rule
    public ActivityTestRule<CounterPage> mActivityTestRule =
            new ActivityTestRule<>(CounterPage.class);

    @Test
    public void buttonPress_IncrementOne(){
        for(int i = 0; i < 10; i++) {
            onView(withId(R.id.click_button)).perform(click());
            onView(withId(R.id.counter_text)).check(matches(withText(String.valueOf(i+1))));
        }
    }

}
