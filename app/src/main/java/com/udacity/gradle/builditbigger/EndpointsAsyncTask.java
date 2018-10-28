package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
//import com.udacity.gradle.builditbigger.javajokes.JokeLibrary;
import com.udacity.gradle.builditbigger.jokedisplay.DisplayActivity;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    public static final String JOKE_EXTRA = "joke";

    private static MyApi myApiService = null;
    private Context mContext;

    public EndpointsAsyncTask(Context context) {
        mContext = context;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {

        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl(mContext.getString(R.string.endpoint_root_url))
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request)
                                throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.tellRandomJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String s) {
        Intent jokeIntent = new Intent(mContext, DisplayActivity.class);
        jokeIntent.putExtra(JOKE_EXTRA, s);
        mContext.startActivity(jokeIntent);
    }
}