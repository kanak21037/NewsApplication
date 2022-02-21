package com.example.newsapplication;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentForButton extends Fragment {
    public Button startServiceButton;
    public Button stopServiceButton;
    //public int i=0;

    private final static String DEBUG_TAG="FragmentForButton";
    public FragmentForButton() {
        Log.i(DEBUG_TAG, "Constructor");
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_for_button, container, false);
        Log.i(DEBUG_TAG, "onCreate");

        startServiceButton= (Button) view.findViewById(R.id.startButton);
        startServiceButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.i(DEBUG_TAG, "startServiceButton");
                getActivity().startService(new Intent(getActivity(),ServiceClass.class));
                Log.i(DEBUG_TAG, "startServiceButton_end");
            }
        });

        stopServiceButton=(Button) view.findViewById(R.id.stopButton);
        stopServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(DEBUG_TAG, "stopServiceButton");
                getActivity().stopService(new Intent(getActivity(), ServiceClass.class));
            }
        });
        return view;
    }
    public void onResume() {
        super.onResume();
    }
}

