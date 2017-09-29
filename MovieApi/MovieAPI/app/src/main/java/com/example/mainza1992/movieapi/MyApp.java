package com.example.mainza1992.movieapi;

import android.app.Application;
import android.content.Context;

/**
 * Created by mainza1992 on 28/09/2017.
 */

public class MyApp extends Application {

    public static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    public static Context getContext() {
        return getApplication().getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

}
