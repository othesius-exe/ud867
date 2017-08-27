package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import com.example.androidjokelibrary.JokeDisplayIntent;
import com.example.caleb.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static String LOG_TAG = EndpointsAsyncTask.class.getSimpleName();
    private static MyApi myApiService = null;
    private Context mContext;
    private ProgressBar mProgressBar;

    public EndpointsAsyncTask(Context context) {
        mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setApplicationName("FinalProject")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            return myApiService.getJokeFromLibrary().execute().getData();
        } catch (IOException e) {
            Log.e(LOG_TAG, "" + e.getMessage());
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Log.i(EndpointsAsyncTask.class.getSimpleName(), "" + result);


        Intent intent = new Intent(mContext, JokeDisplayIntent.class);
        intent.putExtra(JokeDisplayIntent.JOKE_TAG, result);
        mContext.startActivity(intent);
    }
}