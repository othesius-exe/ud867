package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.example.caleb.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static String LOG_TAG = EndpointsAsyncTask.class.getSimpleName();
    private static MyApi myApiService = null;
    private Context mContext;
    private Intent mIntent;

    public EndpointsAsyncTask(Intent intent, Context context) {
        mIntent = intent;
        mContext = context;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://10.0.2.2:8080/_ah/api/");
            myApiService = builder.build();
        }

        try {
            return myApiService.getJokeFromLibrary().execute().getJoke();
        } catch (IOException e) {
            Log.e(LOG_TAG, e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.e(LOG_TAG, result);

    }
}