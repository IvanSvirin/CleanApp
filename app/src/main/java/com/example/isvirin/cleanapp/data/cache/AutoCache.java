package com.example.isvirin.cleanapp.data.cache;

import com.example.isvirin.cleanapp.data.entity.AutoEntity;

import java.util.List;

import rx.Observable;

public interface AutoCache {
    Observable<AutoEntity> getAutos();

    void putAutos(List<AutoEntity> autoEntities);
}
