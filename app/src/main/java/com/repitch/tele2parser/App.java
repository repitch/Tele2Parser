package com.repitch.tele2parser;

import android.app.Application;

import com.repitch.tele2parser.api.ApiManager;

import timber.log.Timber;

/**
 * Created by repitch on 20.02.2018.
 */
public class App extends Application {
    private static App appInstance;

    public static App getInstance() {
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
        ApiManager.init(getApplicationContext());
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
