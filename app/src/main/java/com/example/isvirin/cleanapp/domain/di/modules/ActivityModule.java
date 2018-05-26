package com.example.isvirin.cleanapp.domain.di.modules;

import android.support.v7.app.AppCompatActivity;

import com.example.isvirin.cleanapp.domain.di.PerActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    AppCompatActivity activity() {
        return this.activity;
    }
}
