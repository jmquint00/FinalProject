package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

public class FunctionalTest extends AndroidTestCase {
    public void testAsyncTask() {
        try {
            String fetchJoke = new EndpointsAsyncTask(getContext()).execute().get();
            assertNotNull(fetchJoke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testJoke() {
        try {
            String fetchJoke = new EndpointsAsyncTask(getContext()).execute().get();
            assertNotNull(null, fetchJoke);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
