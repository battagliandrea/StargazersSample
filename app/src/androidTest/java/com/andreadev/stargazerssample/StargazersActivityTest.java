package com.andreadev.stargazerssample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;

import com.andreadev.stargazerssample.ui.repolist.StargazersActivity;

import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import static com.andreadev.stargazerssample.base.AbstractTest.*;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;

/**
 * Created by andrea on 17/12/2017.
 */

@RunWith(AndroidJUnit4.class)
public class StargazersActivityTest {

    @Rule
    public ActivityTestRule<StargazersActivity> mRule = new ActivityTestRule<>(StargazersActivity.class);

    @Test
    public void buttonShouldUpdateText(){

        //No text
        onView(withId(R.id.et_owner)).check(matches(withText("")));
        onView(withId(R.id.et_repo)).check(matches(withText("")));
        onView(withId(R.id.send_btn)).perform(click());

        //Type text and press button
        onView(withId(R.id.et_owner)).perform(typeText("Owner"), closeSoftKeyboard());
        onView(withId(R.id.et_owner)).perform(clearText());
        onView(withId(R.id.et_repo)).perform(typeText("Repository"), closeSoftKeyboard());
        onView(withId(R.id.et_repo)).perform(clearText());

        //Stargazers search
        onView(withId(R.id.et_owner)).perform(typeText("evernote"), closeSoftKeyboard());
        onView(withId(R.id.et_repo)).perform(typeText("android-state"), closeSoftKeyboard());
        onView(withId(R.id.send_btn)).perform(click());

        // Check that list adapter is set and views populated
        RecyclerView recyclerView = (RecyclerView) mRule.getActivity().findViewById(R.id.rv);

        assertNotNull(recyclerView);
        assertNotNull(recyclerView.getAdapter());
        waitForCondition(() -> recyclerView.getAdapter().getItemCount()>0, 10000);

        //Repeat seach
        //Stargazers search
        onView(withId(R.id.et_owner)).perform(clearText());
        onView(withId(R.id.et_repo)).perform(clearText(), closeSoftKeyboard());
        onView(withId(R.id.et_owner)).perform(typeText("test"), closeSoftKeyboard());
        onView(withId(R.id.et_repo)).perform(typeText("test"), closeSoftKeyboard());
        onView(withId(R.id.send_btn)).perform(click());

        assertNotNull(recyclerView);
        assertNotNull(recyclerView.getAdapter());
        waitForCondition(() -> recyclerView.getAdapter().getItemCount()>0, 10000);

        waitFor(3000);
    }
}
