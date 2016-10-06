package com.kotlin.todolist.activities


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView.ViewHolder
import android.test.suitebuilder.annotation.LargeTest
import com.kotlin.todolist.R
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CreateAndEditTask {

    @Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun createAndEditTask() {

        val actionMenuItemView = onView(allOf(withId(R.id.action_new_task), withContentDescription("New Task"), isDisplayed()))
        actionMenuItemView.perform(click())

        val materialEditText = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()))
        materialEditText.perform(click())

        val materialEditText2 = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()))
        materialEditText2.perform(replaceText("Create Task"), closeSoftKeyboard())
        val materialEditText3 = onView(allOf(withId(R.id.taskContentEditText), isDisplayed()))
        materialEditText3.perform(replaceText("blah blah blah"), closeSoftKeyboard())
        val actionMenuItemView2 = onView(allOf(withId(R.id.action_finish_task), withContentDescription("Finish"), isDisplayed()))
        actionMenuItemView2.perform(click())

        val recyclerView = onView(allOf(withId(R.id.tasksRecyclerView), isDisplayed()))
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))
        val materialEditText4 = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()))
        materialEditText4.perform(click())

        val materialEditText5 = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()))
        materialEditText5.perform(click())

        val materialEditText6 = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()))
        materialEditText6.perform(replaceText("Edit a Task"), closeSoftKeyboard())
        val materialEditText7 = onView(allOf(withId(R.id.taskContentEditText), isDisplayed()))
        materialEditText7.perform(replaceText("Edit blah blah blah"), closeSoftKeyboard())

        val actionMenuItemView3 = onView(allOf(withId(R.id.action_finish_task), withContentDescription("Finish"), isDisplayed()))
        actionMenuItemView3.perform(click())

    }

}
