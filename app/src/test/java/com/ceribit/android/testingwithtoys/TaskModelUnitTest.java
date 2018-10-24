package com.ceribit.android.testingwithtoys;

import com.ceribit.android.testingwithtoys.Models.Task;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class TaskModelUnitTest{

    private static final String MOCK_TITLE = "Mock_Title";
    private static final String MOCK_DESCRIPTION = "Mock_DESCRIPTION";

    @Test
    public void taskObject_CheckReturnFunctions() {
        Task mMockTask = new Task(MOCK_TITLE, MOCK_DESCRIPTION);

        assertThat("Checking if MockTask has the correct title stored",
                mMockTask.getTitle(),
                is(equalTo(MOCK_TITLE)));

        assertThat("Checking if MockTask has the correct description stored",
                mMockTask.getDescription(),
                is(equalTo(MOCK_DESCRIPTION)));

        assertNotEquals("Checking if MockTask is not equal to the description",
                mMockTask.getTitle(),
                is(equalTo(MOCK_DESCRIPTION)));

        assertNotEquals("Checking if MockTask is not equal to the description",
                mMockTask.getDescription(),
                is(equalTo(MOCK_TITLE)));

        assertThat("Checking toString function",
                mMockTask.toString(),
                is(equalTo(MOCK_TITLE+":"+MOCK_DESCRIPTION)));
    }
}