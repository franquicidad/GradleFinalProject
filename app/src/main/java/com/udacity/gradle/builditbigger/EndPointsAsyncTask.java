package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.jokeandroidlibrary.DisplayJokeActivity;
import com.example.jokesjavalibrary.JokeJavaLibrary;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndPointsAsyncTask extends AsyncTask<Pair<Context,String>,Void,String>{

    public static final String JOKE_EXTRA = "joke";

    private static MyApi myApiService = null;
    private Context mContext;

    public EndPointsAsyncTask(Context context) {
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
        Intent jokeIntent = new Intent(mContext, DisplayJokeActivity.class);
        jokeIntent.putExtra(JOKE_EXTRA, JokeJavaLibrary.tellRandomJoke());
        jokeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(jokeIntent);
    }

}
