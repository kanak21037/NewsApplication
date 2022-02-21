package com.example.newsapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class FragmentForNews extends Fragment {

    public static TextView newsTitle;
    public static TextView newsBody;
    public static ImageView newsImage;

    public FragmentForNews() {
        // Required empty public constructor
    }

    public static FragmentForNews newInstance(String param1, String param2) {
        FragmentForNews fragment = new FragmentForNews();
        Bundle args = new Bundle();
        return fragment;
    }

    private BroadcastReceiver updateTextViewReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String mTitle = intent.getStringExtra("title");
            newsTitle.setText("Title : "+mTitle);

            String mBody = intent.getStringExtra("body");
            newsBody.setText("Body :"+mBody);
        }
    };

    @Override
    public void onStart() {
        super.onStart();
        //IntentFilter e=getId();
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(updateTextViewReceiver, new IntentFilter("ACTION_UPDATE_TEXT_VIEW"));
    }

    @Override
    public void onStop() {
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(updateTextViewReceiver);
        super.onStop();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_for_news, container, false);

        newsBody=(TextView) view.findViewById(R.id.bodyTextView);
        newsTitle=(TextView) view.findViewById(R.id.titleTextView);

        return view;
    }
}