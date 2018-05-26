package com.example.isvirin.cleanapp.data.repository.datasource;

import com.example.isvirin.cleanapp.data.entity.AutoEntity;

import java.util.List;

import rx.Observable;

public interface AutoDataStore {
    Observable<List<AutoEntity>> autoList();
}
