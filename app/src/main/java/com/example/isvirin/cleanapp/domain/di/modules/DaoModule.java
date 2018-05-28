package com.example.isvirin.cleanapp.domain.di.modules;

import android.content.Context;

import com.example.isvirin.cleanapp.data.cache.GetDaoSession;
import com.example.isvirin.cleanapp.data.entity.DaoSession;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DaoModule {

    @Provides
    @Singleton
    GetDaoSession provideDaoSession(Context context) {
        return new GetDaoSession(context);
    }
}
