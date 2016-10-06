package com.kotlin.todolist.activities


import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
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
class CreateNewTaskTest {

    @Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun createNewTaskTest() {

        val actionMenuItemView = onView(allOf(withId(R.id.action_new_task), isDisplayed()))
        actionMenuItemView.perform(click())

        val materialEditText = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()))
        materialEditText.perform(click())

        val materialEditText2 = onView(allOf(withId(R.id.taskTitleEditText), isDisplayed()))
        materialEditText2.perform(replaceText("Hello task"), closeSoftKeyboard())

        val materialEditText3 = onView(allOf(withId(R.id.taskContentEditText), isDisplayed()))
        materialEditText3.perform(replaceText("create a new task"), closeSoftKeyboard())

        val actionMenuItemView2 = onView(allOf(withId(R.id.action_finish_task), isDisplayed()))
        actionMenuItemView2.perform(click())

    }

}
