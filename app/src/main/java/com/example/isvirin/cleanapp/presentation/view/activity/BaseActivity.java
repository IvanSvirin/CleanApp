package com.example.isvirin.cleanapp.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.isvirin.cleanapp.AutoApplication;
import com.example.isvirin.cleanapp.domain.di.components.ApplicationComponent;
import com.example.isvirin.cleanapp.domain.di.modules.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }
    protected ApplicationComponent getApplicationComponent() {
        return ((AutoApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
