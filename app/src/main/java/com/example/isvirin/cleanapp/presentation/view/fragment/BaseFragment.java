package com.example.isvirin.cleanapp.presentation.view.fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.test.mock.MockApplication;

import com.example.isvirin.cleanapp.AutoApplication;
import com.example.isvirin.cleanapp.domain.di.HasComponent;
import com.example.isvirin.cleanapp.domain.di.components.ApplicationComponent;
import com.example.isvirin.cleanapp.domain.di.modules.ActivityModule;

public abstract class BaseFragment extends Fragment{

    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) this).getComponent());
    }

    protected ApplicationComponent getApplicationComponent(){
        return ((AutoApplication) getActivity().getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule(AppCompatActivity appCompatActivity) {
        return new ActivityModule(appCompatActivity);
    }
}
