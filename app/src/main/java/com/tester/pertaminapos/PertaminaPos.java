package com.tester.pertaminapos;

import android.content.Context;
import app.beelabs.com.codebase.base.BaseApp;
import app.beelabs.com.codebase.di.component.AppComponent;
import app.beelabs.com.codebase.di.component.DaggerAppComponent;

public class PertaminaPos extends BaseApp {

    private static Context context;

    @Override
    public void onCreate(){
        super.onCreate();
        context = getApplicationContext();
        setupBuilder(DaggerAppComponent.builder(), this);
        setupDefaultFont("fonts/SF-Pro-Display-Black.otf");

    }

    public static AppComponent getAppComponent(){
        if(context == null) return  null;
        return getComponent();
    }
}