package com.example.isvirin.cleanapp.presentation.presenter;

import com.example.isvirin.cleanapp.domain.di.PerActivity;
import com.example.isvirin.cleanapp.domain.interactor.DefaultSubscriber;
import com.example.isvirin.cleanapp.domain.interactor.UseCase;
import com.example.isvirin.cleanapp.domain.model.Auto;
import com.example.isvirin.cleanapp.domain.model.mapper.ModelDataMapper;
import com.example.isvirin.cleanapp.presentation.view.AutoListView;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

@PerActivity
public class AutoListPresenter implements Presenter {
    private AutoListView autoListView;
    private final UseCase getAutoListUseCase;
    private final ModelDataMapper modelDataMapper;

    @Inject
    public AutoListPresenter(@Named("autoList") UseCase getAutoListUseCase, ModelDataMapper modelDataMapper) {
        this.getAutoListUseCase = getAutoListUseCase;
        this.modelDataMapper = modelDataMapper;
    }

    public void setView(AutoListView autoListView) {
        this.autoListView = autoListView;
    }

    public void initialize(){
        getAutoListUseCase.execute(new AutoListSubscriber());
    }

    private final class AutoListSubscriber extends DefaultSubscriber<List<Auto>>{
        @Override
        public void onNext(List<Auto> autos) {
            showAutos(autos);
        }
    }

    private void showAutos(List<Auto> autos) {
        autoListView.renderAutoList(modelDataMapper.transformList(autos));
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }
}
