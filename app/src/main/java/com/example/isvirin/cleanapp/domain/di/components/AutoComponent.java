package com.example.isvirin.cleanapp.domain.di.components;

import com.example.isvirin.cleanapp.domain.di.PerActivity;
import com.example.isvirin.cleanapp.domain.di.modules.ActivityModule;
import com.example.isvirin.cleanapp.domain.di.modules.AutoModule;
import com.example.isvirin.cleanapp.presentation.view.fragment.AutoListFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, AutoModule.class})
public interface AutoComponent extends ActivityComponent{
    void inject(AutoListFragment autoListFragment);
}
