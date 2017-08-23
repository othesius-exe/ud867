package com.example.androidjokelibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Class to retrieve the joke that was sent via intent and display it in the TextView
 */


public class JokeDisplayIntent extends AppCompatActivity {

    // Log Tag
    public static final String LOG_TAG = JokeDisplayIntent.class.getSimpleName();

    // Intent tag for jokes
    public static final String JOKE_TAG = "joke";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout where for this activity
        setContentView(R.layout.activity_jokes);

        // Retrieve the intent used to start this activity
        String joke = getIntent().getStringExtra(JOKE_TAG);

        // Set up the TextView that will display the joke
        TextView jokeView = (TextView) findViewById(R.id.jokes_view);

        // Set the Joke text on the TextView
        jokeView.setText(joke);
    }
}
