package com.example.isvirin.cleanapp.domain.interactor;

import com.example.isvirin.cleanapp.domain.executor.PostExecutionThread;
import com.example.isvirin.cleanapp.domain.executor.ThreadExecutor;
import com.example.isvirin.cleanapp.domain.repository.AutoRepository;

import javax.inject.Inject;

import rx.Observable;

public class GetAutoListUseCase extends UseCase {
    private final AutoRepository autoRepository;

    @Inject
    public GetAutoListUseCase(AutoRepository autoRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.autoRepository = autoRepository;
    }

    @Override
    protected Observable buildUseCaseObservable() {
        return this.autoRepository.autos();
    }
}
