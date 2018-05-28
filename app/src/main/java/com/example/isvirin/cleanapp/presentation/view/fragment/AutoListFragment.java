package com.example.isvirin.cleanapp.presentation.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.isvirin.cleanapp.R;
import com.example.isvirin.cleanapp.domain.di.HasComponent;
import com.example.isvirin.cleanapp.domain.di.components.AutoComponent;
import com.example.isvirin.cleanapp.presentation.model.AutoModel;
import com.example.isvirin.cleanapp.presentation.presenter.AutoListPresenter;
import com.example.isvirin.cleanapp.presentation.view.AutoListView;
import com.example.isvirin.cleanapp.presentation.view.adapter.AutoListAdapter;

import java.util.Collection;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AutoListFragment extends BaseFragment implements AutoListView, HasComponent<AutoComponent> {
    private AutoComponent autoComponent;
    @Inject
    AutoListPresenter autoListPresenter;
    @Inject
    AutoListAdapter autoListAdapter;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initilizeInjector();
        this.getComponent(AutoComponent.class).inject(this);
    }

    private void initilizeInjector() {
        autoComponent = DaggerAutoComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule((AppCompatActivity) getActivity()))
                .build();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, fragmentView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(autoListAdapter);
        return fragmentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        autoListPresenter.setView(this);
    }

    @Override
    public void viewAuto(AutoModel autoModel) {
    }

    @Override
    public void renderAutoList(Collection<AutoModel> autoModels) {
        autoListAdapter.setData(autoModels);
    }


    @Override
    public void showError() {

    }

    @Override
    public AutoComponent getComponent() {
        return autoComponent;
    }
}
