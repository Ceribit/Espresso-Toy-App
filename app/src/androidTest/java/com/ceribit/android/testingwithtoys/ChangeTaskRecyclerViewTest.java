package com.ceribit.android.testingwithtoys;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.ceribit.android.testingwithtoys.Adapter.TaskAdapterPage;
import com.ceribit.android.testingwithtoys.RecyclerAdapter.RecyclerTaskAdapter;

import com.ceribit.android.testingwithtoys.RecyclerAdapter.TaskRecyclerAdapterPage;

import com.ceribit.android.testingwithtoys.RecyclerViewMatcher;
import com.ceribit.android.testingwithtoys.TestUtils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.ceribit.android.testingwithtoys.TestUtils.withRecyclerView;
import static org.hamcrest.CoreMatchers.anything;


@RunWith(AndroidJUnit4.class)
public class ChangeTaskRecyclerViewTest {

    private final String DEFAULT_TITLE_TEXT = "title";
    @Rule
    public ActivityTestRule<TaskRecyclerAdapterPage> mActivityTestRule =
            new ActivityTestRule<>(TaskRecyclerAdapterPage.class);

    @Test
    public void buttonPress_ChangedTitle(){
        onView(withId(R.id.recycler_list_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));

        onView(withRecyclerView(R.id.recycler_list_view)
                .atPositionOnView(2, R.id.task_title))
                .check(matches(withText(R.string.task_changed_title)));
    }

    @Test
    public void scrollDownThenButtonPress_ChangedTitle(){
        onView(ViewMatchers.withId(R.id.recycler_list_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(90, click()));

        onView(withRecyclerView(R.id.recycler_list_view)
                .atPositionOnView(90, R.id.task_title))
                .check(matches(withText(R.string.task_changed_title)));
    }

    @Test
    public void pressItemThenScrollOutAndIn_UnchangedTitle(){
        onView(ViewMatchers.withId(R.id.recycler_list_view))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.recycler_list_view))
                .perform(RecyclerViewActions.scrollToPosition(50));

        onView(withId(R.id.recycler_list_view))
               .perform(RecyclerViewActions.scrollToPosition(0));


        onView(withRecyclerView(R.id.recycler_list_view)
                .atPositionOnView(0, R.id.task_title))
                .check(matches(withText(DEFAULT_TITLE_TEXT+"0")));
    }

}