package com.mytaxi.android_demo.activities;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertTrue;

/**
 * Test authentication screen's functionality
 * @see AuthenticationActivity
 */
@RunWith(AndroidJUnit4.class)
public class AuthenticationActivityTest {
    @Rule
    public ActivityTestRule<AuthenticationActivity> activityRule =
            new ActivityTestRule<>(AuthenticationActivity.class);

    /**
     * happy path which will login success
     */
    @Test
    public void testAttemptLoginHappyPath() {
        onView(ViewMatchers.withId(R.id.edt_username))
                .perform(click())
                .perform(typeText("whiteelephant261"));
        onView(withId(R.id.edt_password))
                .perform(click())
                .perform(typeText("video"));
        IdlingRegistry.getInstance()
                .register(activityRule.getActivity().getIdlingResource());
        onView(withId(R.id.btn_login))
                .perform(click());
        assertTrue(activityRule.getActivity().isFinishing());
    }

    /**
     * should add failed callback in {@link com.mytaxi.android_demo.utils.network.HttpClient.UserCallback}
     */
    @Test
    public void testAttemptLoginUnHappyPathForgotToInputField() {}
}
