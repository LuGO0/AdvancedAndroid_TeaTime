package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.teatime.model.Tea;

import org.hamcrest.core.Is;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {

    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule=new ActivityTestRule<>(MenuActivity.class);

    @Test
    void clickGridViewItem_OpensOrderActivity(){

        //anything is a data matcher
        onData(anything())
                //this is a adapterMatcher
                .inAdapterView(withId(R.id.tea_grid_view))
                //this is a postion matcher in the adapter
                .atPosition(1)
                //perform some work you wanna doj8
                .perform(click());

        // Checks that the OrderActivity opens with the correct tea name displayed
        onView(withId(R.id.tea_name_text_view)).check(matches(withText("Green Tea")));

    }
}
