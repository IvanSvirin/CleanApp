package com.example.isvirin.cleanapp.data.repository.datasource;

import android.content.Context;

import com.example.isvirin.cleanapp.data.cache.AutoCache;
import com.example.isvirin.cleanapp.data.entity.AutoEntity;
import com.example.isvirin.cleanapp.data.rest.ApiInterface;

import java.util.List;

import rx.Observable;

public class CloudAutoDataStore implements AutoDataStore {
    private final Context context;
    private final ApiInterface apiInterface;
    private final AutoCache autoCache;

    public CloudAutoDataStore(Context context1, ApiInterface apiInterface1, AutoCache autoCache1) {
        this.context = context1;
        this.apiInterface = apiInterface1;
        this.autoCache = autoCache1;
    }

    @Override
    public Observable<List<AutoEntity>> autoList() {
        return this.apiInterface.autoEntities().concatMap(response -> Observable.just(response.getAutoEntityList()));
    }
}
