package com.apsoft.rxmvp.sample;

import android.os.Bundle;

import com.apsoft.rxmvp.library.views.RxActivity;

public class MainActivity extends RxActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
