package com.example.android.trailers;

import android.app.Application;
import android.content.Context;

/**
 * Created by 517107 on 11/3/2015.
 */
public class MyApplication extends Application {

    private static MyApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance=this;
    }

    public static MyApplication getsInstance(){
       return sInstance;
    }

    public static Context getAppContext(){
        return sInstance.getApplicationContext();
    }
}
