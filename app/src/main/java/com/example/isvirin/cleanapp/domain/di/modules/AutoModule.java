package com.example.isvirin.cleanapp.domain.di.modules;

import com.example.isvirin.cleanapp.domain.di.PerActivity;
import com.example.isvirin.cleanapp.domain.interactor.GetAutoListUseCase;
import com.example.isvirin.cleanapp.domain.interactor.UseCase;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class AutoModule {

    @Provides
    @PerActivity
    @Named("autoList")
    UseCase provideGetAutoListUseCase(GetAutoListUseCase getAutoListUseCase){
        return getAutoListUseCase;
    }
}
