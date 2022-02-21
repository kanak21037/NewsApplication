package com.example.newsapplication;

import static java.lang.Thread.sleep;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Provider;
import java.util.ArrayList;
import java.util.HashMap;

/*
public class DownloadNewsService extends Service {


    DownloadNewsService() {
        Log.i(DEBUG_TAG, " Constructor");
    }


    @Override
    public void onCreate() {


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

    }

    public void onDestroy() {
        //container.setBegining(i);
        super.onDestroy();
//        //flag=false;
//        Intent broadcastIntent = new Intent();
//        broadcastIntent.setAction("restartservice");
//        broadcastIntent.putExtra("resumeNewsId",i);
//        broadcastIntent.setClass(this, MyReceiver.class);
//        this.sendBroadcast(broadcastIntent);


    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}

*/