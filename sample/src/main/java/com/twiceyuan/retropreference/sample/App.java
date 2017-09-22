package com.twiceyuan.retropreference.sample;

import android.app.Application;

import com.twiceyuan.retropreference.RetroPreference;

/**
 * Created by twiceYuan on 2017/9/22.
 *
 * Application instance
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetroPreference.initDefaultPreference(this, Settings.class, MODE_PRIVATE);
    }
}
