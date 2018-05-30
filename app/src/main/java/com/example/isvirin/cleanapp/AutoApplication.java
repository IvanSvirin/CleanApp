package com.example.isvirin.cleanapp;

import android.app.Application;

import com.example.isvirin.cleanapp.domain.di.components.ApplicationComponent;
import com.example.isvirin.cleanapp.domain.di.components.DaggerApplicationComponent;
import com.example.isvirin.cleanapp.domain.di.modules.ApplicationModule;

public class AutoApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
