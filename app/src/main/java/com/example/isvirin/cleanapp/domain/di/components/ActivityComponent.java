package com.example.isvirin.cleanapp.domain.di.components;

import android.support.v7.app.AppCompatActivity;

import com.example.isvirin.cleanapp.domain.di.PerActivity;
import com.example.isvirin.cleanapp.domain.di.modules.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    AppCompatActivity activity();
}
