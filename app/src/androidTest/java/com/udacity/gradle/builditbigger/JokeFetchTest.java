package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.javajokes.JokeLibrary;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;


@RunWith(AndroidJUnit4.class)
public class JokeFetchTest {


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void jokeIsNotNull() {

        JokeLibrary lib = new JokeLibrary();

        String jokes = JokeLibrary.tellRandomJoke();


        onView(withId(R.id.joke_button)).perform(click());
        onView(withId(R.id.joke_display_text)).check(matches(not(withText("null"))));
        onView(withId(R.id.joke_display_text)).check(matches(not(withText(""))));
        onView(withId(R.id.joke_display_text)).check(matches(not(withText("connect time out"))));
        onView(withId(R.id.joke_display_text)).check(matches(not(withText("failed"))));


    }


}
