package com.example.isvirin.cleanapp.data.repository.datasource;

import com.example.isvirin.cleanapp.data.entity.AutoEntity;

import java.util.List;

import rx.Observable;

public class AutoDiskDataStore implements AutoDataStore {
    @Override
    public Observable<List<AutoEntity>> autoList() {
        return null;
    }
}
