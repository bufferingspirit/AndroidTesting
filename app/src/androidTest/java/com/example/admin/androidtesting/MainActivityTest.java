package com.example.admin.androidtesting;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Created by Admin on 8/29/2017.
 */

public class MainActivityTest {

    public double Number1 = 9;
    public double Number2 = 9;
    public static final String PACKAGE_NAME = "com.example.admin.androidtesting";

   /* @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>((MainActivity.class));*/

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule = new IntentsTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setup(){
        Number1 = 9;
        Number2 = 9;
    }

    @Test
    public void testing_addition_views(){
        onView(withId(R.id.etValue1)).perform(typeText(String.valueOf(Number1)), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.etValue2)).perform(typeText(String.valueOf(Number2)), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.btnAdd)).perform(click());

        onView(withId(R.id.tvSolution)).check(matches(withText(String.valueOf(18))));
    }

    @Test
    public void testing_intentValueForTheResult(){
        onView(withId(R.id.etValue1)).perform(typeText(String.valueOf(Number1)), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.etValue2)).perform(typeText(String.valueOf(Number2)), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.btnAdd)).perform(click());
        onView(withId(R.id.btnStartActivity)).perform(click());

        intended(allOf(
                hasComponent(hasShortClassName(".Main2Activity")),
                toPackage(PACKAGE_NAME),
        hasExtra(MainActivity.KEY_RESULT, "18.0")));
    }
}
