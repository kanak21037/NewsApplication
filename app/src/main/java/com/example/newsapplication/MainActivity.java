package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private final static String DEBUG_TAG="MainActivity";
    //public int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(DEBUG_TAG,"MainActivity");

        FragmentManager fragmentManagerButton=getSupportFragmentManager();
        FragmentTransaction fragmentTransactionButton=fragmentManagerButton.beginTransaction();
        FragmentForButton fragmentForButton=new FragmentForButton();
        fragmentTransactionButton.replace(R.id.buttonFrame,fragmentForButton);
        fragmentTransactionButton.commit();

        Log.i(DEBUG_TAG,"fragmentForNews");

        FragmentManager fragmentManagerNews=getSupportFragmentManager();
        FragmentTransaction fragmentTransactionNews=fragmentManagerNews.beginTransaction();
        FragmentForNews fragmentForNews=new FragmentForNews();
        fragmentTransactionNews.replace(R.id.newsFrame,fragmentForNews);
        fragmentTransactionNews.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Intent broadcastIntent = new Intent();
//        broadcastIntent.setAction("restartservice");
//        //broadcastIntent.putExtra("resumeNewsId",i);
//        broadcastIntent.setClass(this, MyReceiver.class);
//        this.sendBroadcast(broadcastIntent);
    }
}

