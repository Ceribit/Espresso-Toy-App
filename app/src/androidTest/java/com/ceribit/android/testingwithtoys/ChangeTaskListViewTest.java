package com.ceribit.android.testingwithtoys;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.ceribit.android.testingwithtoys.Adapter.TaskAdapterPage;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;

@RunWith(AndroidJUnit4.class)
public class ChangeTaskListViewTest {

    @Rule
    public ActivityTestRule<TaskAdapterPage> mActivityTestRule =
            new ActivityTestRule<>(TaskAdapterPage.class);

    @Test
    public void buttonPress_ChangedTitle(){
        onData(anything()).inAdapterView(withId(R.id.task_list_view)).atPosition(0).perform(click());

        onData(anything()).inAdapterView(withId(R.id.task_list_view)).atPosition(0)
                .onChildView(withId(R.id.task_title))
                .check(matches(withText("You temporarily changed the title")));
    }

}