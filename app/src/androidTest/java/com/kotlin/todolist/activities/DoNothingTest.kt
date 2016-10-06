package com.kotlin.todolist.activities


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.test.suitebuilder.annotation.LargeTest
import com.kotlin.todolist.R
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class DoNothingTest {

    @Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun doNothingTest() {

        val actionMenuItemView = onView(allOf(withId(R.id.action_new_task), withContentDescription("New Task"), isDisplayed()))
        actionMenuItemView.perform(click())

        val materialEditText = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()))
        materialEditText.perform(click())

        val imageButton = onView(allOf(withContentDescription("Navigate up"),
                                       withParent(allOf(withId(R.id.action_bar),
                                       withParent(withId(R.id.action_bar_container)))),
                                       isDisplayed()))
        imageButton.perform(click())

    }

}
