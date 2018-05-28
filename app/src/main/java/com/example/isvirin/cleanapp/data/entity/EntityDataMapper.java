package com.example.isvirin.cleanapp.data.entity;

import com.example.isvirin.cleanapp.domain.model.Auto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EntityDataMapper {
    @Inject
    public EntityDataMapper() {
    }

    public Auto transform(AutoEntity auto) {
        Auto autoModel = new Auto(auto.getModel());
        autoModel.setManufacturer(auto.getManufacturer());
        autoModel.setPrice(auto.getPrice());
        autoModel.setWiki(auto.getWiki());
        autoModel.setImg(auto.getImg());
        return autoModel;
    }

    public List<Auto> transformList(List<AutoEntity> autoCollection) {
        List<Auto> autoModelCollection = new ArrayList<>();
        for (AutoEntity auto : autoCollection) {
            autoModelCollection.add(transform(auto));
        }
        return autoModelCollection;
    }
}
