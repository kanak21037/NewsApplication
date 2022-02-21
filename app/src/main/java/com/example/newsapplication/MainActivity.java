package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final static String DEBUG_TAG="MainActivity";
    Button next;
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

        next=findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                //intent.putExtra("arrayList", symptomslist);
                //String u = mUserInputET.getText().toString();
                //intent.putExtra("pName", u);
                startActivity(intent);
                Log.i(DEBUG_TAG, "After Activity1 Intent");

            }
        });


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

