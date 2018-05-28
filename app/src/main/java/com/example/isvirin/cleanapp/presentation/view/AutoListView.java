package com.example.isvirin.cleanapp.presentation.view;

import com.example.isvirin.cleanapp.presentation.model.AutoModel;

import java.util.Collection;
import java.util.List;

public interface AutoListView extends LoadDataView {
    void viewAuto(AutoModel autoModel);

    void renderAutoList(Collection<AutoModel> autoModels);
}
