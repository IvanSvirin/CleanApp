package com.example.isvirin.cleanapp.domain.di.modules;

import com.example.isvirin.cleanapp.data.rest.ApiInterface;
import com.example.isvirin.cleanapp.data.rest.RetrofitClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RestModule {
    @Provides
    @Singleton
    RetrofitClient provideRetrofitClient() {
        return new RetrofitClient();
    }

    @Provides
    @Singleton
    ApiInterface provideApiInterface(RetrofitClient retrofitClient) {
        return retrofitClient.getRetrofit().create(ApiInterface.class);
    }
}
