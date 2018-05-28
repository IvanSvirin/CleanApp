package com.example.isvirin.cleanapp.data.entity;

import com.example.isvirin.cleanapp.data.entity.AutoEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {
    @SerializedName("data")
    private List<AutoEntity> autoEntityList;

    public Response(List<AutoEntity> autoEntityList) {
        this.autoEntityList = autoEntityList;
    }

    public List<AutoEntity> getAutoEntityList() {
        return autoEntityList;
    }

    public void setAutoEntityList(List<AutoEntity> autoEntityList) {
        this.autoEntityList = autoEntityList;
    }
}
