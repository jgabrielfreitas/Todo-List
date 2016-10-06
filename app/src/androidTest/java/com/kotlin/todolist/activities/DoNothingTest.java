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
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DoNothingTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void doNothingTest() {

        ViewInteraction actionMenuItemView = onView(allOf(withId(R.id.action_new_task), withContentDescription("New Task"), isDisplayed()));
        actionMenuItemView.perform(click());

        ViewInteraction materialEditText = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()));
        materialEditText.perform(click());

        ViewInteraction imageButton = onView(allOf(withContentDescription("Navigate up"),
                                             withParent(allOf(withId(R.id.action_bar),
                                             withParent(withId(R.id.action_bar_container)))),
                                             isDisplayed()));
        imageButton.perform(click());

    }

}
