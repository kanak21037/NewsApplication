package com.example.newsapplication;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Provider;

public class DownloadNewsService extends Service {
    private final static String DEBUG_TAG="DownloadNewsService";
    public Thread thread;
    int i=0;
    boolean flag=true;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(DEBUG_TAG, "onCreate");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NewThread thread=new NewThread();
        thread.start();
        thread.run();


        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show();
        Log.i(DEBUG_TAG, "onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(DEBUG_TAG, "onDestroy");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    class NewThread extends Thread{
        private final static String DEBUG_TAG="NewThread";
        public NewThread() {
            super();
        }
        @Override
        public synchronized void start() {
            super.start();
        }
        @Override
        public void run() {
            Log.i(DEBUG_TAG, "run");
            NetworkConnectionAsyncTask networkConnectionAsyncTask=new NetworkConnectionAsyncTask();
            ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo= connectivityManager.getActiveNetworkInfo();
            if(networkInfo!=null && networkInfo.isConnected()) {
                networkConnectionAsyncTask.execute(i);
            }
            else{
                Toast.makeText(getApplicationContext(),"Not Connected to network",Toast.LENGTH_SHORT).show();
                Log.i(DEBUG_TAG, "Not Connected to network");
            }
        }
    }
}



//        return START_STICKY;
