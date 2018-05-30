package com.example.isvirin.cleanapp.domain.di.components;

import android.content.Context;

import com.example.isvirin.cleanapp.data.cache.AutoCache;
import com.example.isvirin.cleanapp.domain.di.modules.ApplicationModule;
import com.example.isvirin.cleanapp.domain.di.modules.DaoModule;
import com.example.isvirin.cleanapp.domain.di.modules.RestModule;
import com.example.isvirin.cleanapp.domain.executor.PostExecutionThread;
import com.example.isvirin.cleanapp.domain.executor.ThreadExecutor;
import com.example.isvirin.cleanapp.domain.repository.AutoRepository;
import com.example.isvirin.cleanapp.presentation.view.activity.BaseActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RestModule.class, DaoModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    AutoRepository autoRepository();

    AutoCache autoCache();
}
