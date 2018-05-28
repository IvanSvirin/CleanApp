package com.example.isvirin.cleanapp.data.rest;

import com.example.isvirin.cleanapp.data.entity.Response;

import javax.inject.Singleton;

import retrofit2.http.GET;
import rx.Observable;

@Singleton
public interface ApiInterface {
    @GET("cars.json")
    Observable<Response> autoEntities();
}
