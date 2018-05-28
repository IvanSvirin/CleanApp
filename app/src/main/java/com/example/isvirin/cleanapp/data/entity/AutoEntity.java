package com.example.isvirin.cleanapp.data.entity;

import android.support.v4.media.VolumeProviderCompat;

import com.example.isvirin.cleanapp.data.entity.daoconverter.AutoType;
import com.example.isvirin.cleanapp.data.entity.daoconverter.AutoTypeConverter;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(indexes = {
        @Index(value = "model ASC", unique = true)
})
public class AutoEntity {
    @Id
    private Long id;
    @NotNull
    @SerializedName("manufacturer")
    private String manufacturer;
    @NotNull
    @SerializedName("model")
    private String model;
    @NotNull
    @SerializedName("price")
    private float price;
    @NotNull
    @SerializedName("wiki")
    private String wiki;
    @NotNull
    @SerializedName("img")
    private String img;

    @Convert(converter = AutoTypeConverter.class, columnType = String.class)
    private AutoType autoType;
    
    public AutoEntity() {
    }

    public AutoEntity(String model) {
        this.model = model;
    }

    @Generated(hash = 717840857)
    public AutoEntity(Long id, @NotNull String manufacturer, @NotNull String model,
            float price, @NotNull String wiki, @NotNull String img,
            AutoType autoType) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.wiki = wiki;
        this.img = img;
        this.autoType = autoType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getWiki() {
        return wiki;
    }

    public void setWiki(String wiki) {
        this.wiki = wiki;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AutoType getAutoType() {
        return this.autoType;
    }

    public void setAutoType(AutoType autoType) {
        this.autoType = autoType;
    }
}
