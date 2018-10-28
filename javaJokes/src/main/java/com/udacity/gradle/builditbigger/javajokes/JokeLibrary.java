package com.udacity.gradle.builditbigger.javajokes;

import java.util.Random;

public class JokeLibrary {

    private static final String[] jokes =
            {"Did you hear about the crook who stole a calendar? He got twelve months",
                    "What's the difference between a good joke and a bad joke... timing",
                    "Why are iPhone chargers not called Apple Juice?!",
                    "How does a computer get drunk? It takes screenshots."};

    public static String tellRandomJoke() {
        return jokes[new Random().nextInt(jokes.length)];
    }
}