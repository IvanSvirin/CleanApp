package com.example.isvirin.cleanapp.data.repository.datasource;

import android.content.Context;

import com.example.isvirin.cleanapp.data.cache.AutoCache;
import com.example.isvirin.cleanapp.data.rest.ApiInterface;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AutoDataStoreFactory {
    private final Context context;
    private final AutoCache autoCache;
    private final ApiInterface apiInterface;

    @Inject
    public AutoDataStoreFactory(Context context, AutoCache autoCache, ApiInterface apiInterface) {
        this.context = context;
        this.autoCache = autoCache;
        this.apiInterface = apiInterface;
    }

    public AutoDataStore createList(){
        AutoDataStore autoDataStore;
        return createCloudDataStore();
    }

    private AutoDataStore createCloudDataStore() {
        return new CloudAutoDataStore(context, apiInterface, autoCache, context1, apiInterface1, autoCache1);
    }
}
