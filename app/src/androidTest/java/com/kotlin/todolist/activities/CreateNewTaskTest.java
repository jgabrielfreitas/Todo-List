package com.kotlin.todolist.activities;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.kotlin.todolist.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CreateNewTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void createNewTaskTest() {

        ViewInteraction actionMenuItemView = onView(allOf(withId(R.id.action_new_task), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction materialEditText = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()));
        materialEditText.perform(click());

        ViewInteraction materialEditText2 = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()));
        materialEditText2.perform(replaceText("Hello task"), closeSoftKeyboard());

        ViewInteraction materialEditText3 = onView(allOf(withId(R.id.taskContentEditText), isDisplayed()));
        materialEditText3.perform(replaceText("create a new task"), closeSoftKeyboard());

        ViewInteraction actionMenuItemView2 = onView(allOf(withId(R.id.action_finish_task), isDisplayed()));
        actionMenuItemView2.perform(click());

    }

}
