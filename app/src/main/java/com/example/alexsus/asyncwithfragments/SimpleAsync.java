package com.example.alexsus.asyncwithfragments;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

class SimpleAsync extends AsyncTask<String, Void, String> {
    private static final String TAG = "ASYNC_TASK";
    private Context mContext;

    SimpleAsync(Context context) {
        mContext = context; //get activity context
    }

    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        for (int i = 0; i < 20; i++) {
            Log.d(TAG, "Executing AsyncTask... " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    protected void onPostExecute(String string) {
        super.onPostExecute(string);
        Log.d(TAG, "Executing finished.");
    }

}