package com.example.isvirin.cleanapp.domain.di.modules;

import android.content.Context;
import com.example.isvirin.cleanapp.AutoApplication;
import com.example.isvirin.cleanapp.data.cache.AutoCache;
import com.example.isvirin.cleanapp.data.cache.AutoCacheImpl;
import com.example.isvirin.cleanapp.data.executor.JobExecutor;
import com.example.isvirin.cleanapp.data.repository.AutoDataRepository;
import com.example.isvirin.cleanapp.domain.executor.PostExecutionThread;
import com.example.isvirin.cleanapp.domain.executor.ThreadExecutor;
import com.example.isvirin.cleanapp.domain.repository.AutoRepository;
import com.example.isvirin.cleanapp.presentation.view.UIThread;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private AutoApplication autoApplication;

    public ApplicationModule(AutoApplication autoApplication) {
        this.autoApplication = autoApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext(){
        return this.autoApplication;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor){
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread){
        return uiThread;
    }

    @Provides
    @Singleton
    AutoRepository provideAutoRepository(AutoDataRepository autoRepository){
        return autoRepository;
    }

    @Provides
    @Singleton
    AutoCache provideAutoCache(AutoCacheImpl autoCache){
        return autoCache;
    }
}
