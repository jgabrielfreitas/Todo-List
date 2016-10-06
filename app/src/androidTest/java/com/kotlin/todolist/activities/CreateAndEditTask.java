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
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CreateAndEditTask {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void createAndEditTask() {

        ViewInteraction actionMenuItemView = onView(allOf(withId(R.id.action_new_task), withContentDescription("New Task"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction materialEditText = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()));
        materialEditText.perform(click());

        ViewInteraction materialEditText2 = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()));
        materialEditText2.perform(replaceText("Create Task"), closeSoftKeyboard());
        ViewInteraction materialEditText3 = onView(allOf(withId(R.id.taskContentEditText), isDisplayed()));
        materialEditText3.perform(replaceText("blah blah blah"), closeSoftKeyboard());
        ViewInteraction actionMenuItemView2 = onView(allOf(withId(R.id.action_finish_task), withContentDescription("Finish"), isDisplayed()));
        actionMenuItemView2.perform(click());

        ViewInteraction recyclerView = onView(allOf(withId(R.id.tasksRecyclerView), isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(0, click()));
        ViewInteraction materialEditText4 = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()));
        materialEditText4.perform(click());

        ViewInteraction materialEditText5 = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()));
        materialEditText5.perform(click());

        ViewInteraction materialEditText6 = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()));
        materialEditText6.perform(replaceText("Edit a Task"), closeSoftKeyboard());
        ViewInteraction materialEditText7 = onView(allOf(withId(R.id.taskContentEditText), isDisplayed()));
        materialEditText7.perform(replaceText("Edit blah blah blah"), closeSoftKeyboard());

        ViewInteraction actionMenuItemView3 = onView(allOf(withId(R.id.action_finish_task), withContentDescription("Finish"), isDisplayed()));
        actionMenuItemView3.perform(click());

    }

}
