package com.udacity.gradle.builditbigger.jokedisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA = "joke";

    private String mJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        if (getIntent() != null) {
            Intent intent = getIntent();
            mJoke = intent.getStringExtra(JOKE_EXTRA);
            ((TextView) findViewById(R.id.joke_display_text)).setText(mJoke);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
