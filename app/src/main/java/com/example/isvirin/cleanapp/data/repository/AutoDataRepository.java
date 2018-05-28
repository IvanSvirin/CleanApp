package com.example.isvirin.cleanapp.data.repository;

import com.example.isvirin.cleanapp.data.entity.EntityDataMapper;
import com.example.isvirin.cleanapp.data.repository.datasource.AutoDataStore;
import com.example.isvirin.cleanapp.data.repository.datasource.AutoDataStoreFactory;
import com.example.isvirin.cleanapp.domain.model.Auto;
import com.example.isvirin.cleanapp.domain.repository.AutoRepository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class AutoDataRepository implements AutoRepository{
    private final EntityDataMapper entityDataMapper;
    private final AutoDataStoreFactory autoDataStoreFactory;

    @Inject
    public AutoDataRepository(EntityDataMapper entityDataMapper, AutoDataStoreFactory autoDataStoreFactory) {
        this.entityDataMapper = entityDataMapper;
        this.autoDataStoreFactory = autoDataStoreFactory;
    }

    @Override
    public Observable<List<Auto>> autos() {
         AutoDataStore autoDataStore = autoDataStoreFactory.createList();
         return autoDataStore.autoList().map(entityDataMapper::transformList);
    }
}
