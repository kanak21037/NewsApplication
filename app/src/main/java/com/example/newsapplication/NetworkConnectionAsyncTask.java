package com.example.newsapplication;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class NetworkConnectionAsyncTask extends AsyncTask<Integer, Void, Boolean> {
    private static final String DEBUG_TAG = "NetworkConnAsyncTask";
    ArrayList<HashMap<String, String>> newsArrayList;
    int i;

    @Override
    protected Boolean doInBackground(Integer... integers) {

        String surl="https://petwear.in/mc2022/news/news_0.json";
        String jsonStr=connectToNetwork(surl);

        Log.e(DEBUG_TAG, "Response from url: " + jsonStr);
        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                String body= jsonObj.getString("title");
                String image_url= jsonObj.getString("image-url");
                String title= jsonObj.getString("title");

                HashMap<String, String> news = new HashMap<>();
                // adding each child node to HashMap key => value
                news.put("body", body);
                news.put("image-url", image_url);
                news.put("title", title);
                newsArrayList.add(news);

                Log.i(DEBUG_TAG, news.get(title));
            }
            catch (JSONException e) {
                Log.e(DEBUG_TAG, "Json parsing error: " + e.getMessage());
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getApplicationContext(), "Json parsing error: " + e.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                });
                e.printStackTrace();
            }
        }
        else {
            Log.e(DEBUG_TAG, "Couldn't get json from server.");
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    Toast.makeText(getApplicationContext(), "Couldn't get json from server. Check LogCat for possible errors!", Toast.LENGTH_LONG).show();
//                }
//            });
        }
        return null;
    }

    @Override
        protected void onPreExecute() {
            Log.i(DEBUG_TAG, "onPreExecute");
            this.i=i;
        }


        private String connectToNetwork(String strUrl){
            boolean flag=true;
            String response=null;
            //while(flag) {
                try {
                    URL url = new URL(strUrl);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();

                    InputStream in= new BufferedInputStream(connection.getInputStream());
                    response = convertStreamToString(in);
                    connection.disconnect();
                    Log.i(DEBUG_TAG, "connected for file"+i);
                    i++;

                } catch (IOException e) {
                    e.printStackTrace();
                }
           // }
            return response;
        }

    private String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }


}
