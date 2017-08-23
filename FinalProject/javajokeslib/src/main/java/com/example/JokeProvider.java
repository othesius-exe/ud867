package com.example;

import java.util.Random;

/**
 * Class will provide jokes at random from an array.
 */

public class JokeProvider {

    // Log Tag!
    public static final String LOG_TAG = JokeProvider.class.getSimpleName();

    // Array of funny string things.
    private static final String JOKES[] = {
            "So this programmer goes out on a date with a hot chick",
            "Q: What is the Object-Oriented way to become wealthy? A: Inheritance",
            "If you put a million monkeys at a million keyboards, one of them will eventually write a Java program. The rest will write Perl programs",
            "If you\\'re happy and you know it, Syntax Error!",
            "Q: How many programmers does it take to change a light bulb? A: None, that\\'s a hardware problem.",
            "An SQL query goes into a bar, walks up to two tables and asks, \"Can I join you?\""
    };

    public static String getJoke() {
        int i = new Random().nextInt(JOKES.length);
        System.out.println(LOG_TAG + ": i = " + Integer.toString(i));
        return JOKES[i];
    }
}
