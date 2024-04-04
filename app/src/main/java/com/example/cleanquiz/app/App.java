package com.example.cleanquiz.app;

import android.app.Application;

import com.example.cleanquiz.data.source.Pref;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Pref.init(this);
    }
}
