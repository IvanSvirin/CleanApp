package com.example.isvirin.cleanapp.domain.executor;

import rx.Scheduler;

public interface PostExecutionThread {
    Scheduler getScheduler();
}
