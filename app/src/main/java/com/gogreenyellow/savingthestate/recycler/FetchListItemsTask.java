package com.gogreenyellow.savingthestate.recycler;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * The AsyncTask fetches the example data from the API.
 *
 * @author wjanuszek
 */
public class FetchListItemsTask extends AsyncTask<Void, Void, JSONArray> {

    private WeakReference<Callback> callback;

    public FetchListItemsTask(Callback callback) {
        this.callback = new WeakReference<>(callback);
    }

    @Override
    protected JSONArray doInBackground(Void... voids) {
        try {
            final String endpoint = "http://gogreenyellow.com/articles/article_005/api/listItems.json";

            URL url = new URL(endpoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return new JSONArray(stringBuilder.toString());
        } catch (IOException | JSONException e) {
            return null;
        }
    }

    @Override
    protected void onPostExecute(JSONArray jsonArray) {
        if (callback.get() != null) {
            if (jsonArray == null) {
                callback.get().failedToGetItems();
            } else {
                callback.get().gotItems(jsonArray);
            }
        }
    }

    interface Callback {
        void gotItems(JSONArray items);

        void failedToGetItems();
    }
}
