package com.example.newsapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManagerButton=getSupportFragmentManager();
        FragmentTransaction fragmentTransactionButton=fragmentManagerButton.beginTransaction();
        FragmentForButton fragmentForButton=new FragmentForButton();
        fragmentTransactionButton.add(R.id.buttonFrame,fragmentForButton);
        fragmentTransactionButton.commit();

        FragmentManager fragmentManagerNews=getSupportFragmentManager();
        FragmentTransaction fragmentTransactionNews=fragmentManagerNews.beginTransaction();
        FragmentForNews fragmentForNews=new FragmentForNews();
        fragmentTransactionNews.add(R.id.newsFrame,fragmentForNews);
        fragmentTransactionNews.commit();
    }
}