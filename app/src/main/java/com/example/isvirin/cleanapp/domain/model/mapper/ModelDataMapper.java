package com.example.isvirin.cleanapp.domain.model.mapper;

import com.example.isvirin.cleanapp.domain.di.PerActivity;
import com.example.isvirin.cleanapp.domain.model.Auto;
import com.example.isvirin.cleanapp.presentation.model.AutoModel;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

@PerActivity
public class ModelDataMapper {
    @Inject
    public ModelDataMapper() {
    }

    public AutoModel transform(Auto auto){
        AutoModel autoModel = new AutoModel(auto.getModel());
        autoModel.setManufacturer(auto.getManufacturer());
        autoModel.setPrice(auto.getPrice());
        autoModel.setWiki(auto.getWiki());
        autoModel.setImg(auto.getImg());
        return autoModel;
    }

    public Collection<AutoModel> transformList(Collection<Auto> autoCollection){
        Collection<AutoModel> autoModelCollection = new ArrayList<>();
        for (Auto auto : autoCollection) {
            autoModelCollection.add(transform(auto));
        }
        return autoModelCollection;
    }
}
