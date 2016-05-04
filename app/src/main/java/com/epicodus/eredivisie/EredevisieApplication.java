package com.epicodus.eredivisie;

import android.app.Application;

import com.firebase.client.Firebase;

public class EredevisieApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}

