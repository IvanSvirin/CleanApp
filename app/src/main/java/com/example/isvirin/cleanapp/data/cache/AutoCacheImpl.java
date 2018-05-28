package com.example.isvirin.cleanapp.data.cache;


import android.content.Context;

import com.example.isvirin.cleanapp.data.entity.AutoEntity;
import com.example.isvirin.cleanapp.data.entity.AutoEntityDao;
import com.example.isvirin.cleanapp.domain.executor.ThreadExecutor;

import org.greenrobot.greendao.query.Query;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class AutoCacheImpl implements AutoCache {
    private final Context context;
    private final GetDaoSession getDaoSession;
    private final ThreadExecutor threadExecutor;

    @Inject
    public AutoCacheImpl(Context context, GetDaoSession getDaoSession, ThreadExecutor threadExecutor) {
        this.context = context;
        this.getDaoSession = getDaoSession;
        this.threadExecutor = threadExecutor;
    }

    @Override
    public Observable<List<AutoEntity>> getAutos() {
        return Observable.unsafeCreate(
                subscriber -> {
                    AutoEntityDao autoEntityDao = getDaoSession.getDaoSession().getAutoEntityDao();
                    Query<AutoEntity> query = autoEntityDao.queryBuilder().orderAsc(AutoEntityDao.Properties.Id).build();
                    List<AutoEntity> autoEntities = query.list();
                    if (autoEntities != null) {
                        subscriber.onNext(autoEntities);
                        subscriber.onCompleted();
                    } else {
                        subscriber.onError(new Throwable());
                    }
                }
        );
    }

    @Override
    public void putAutos(List<AutoEntity> autoEntities) {
        if (autoEntities != null) {
            executeAsynchronously(new CacheWriter(getDaoSession, autoEntities));
        }
    }

    private void executeAsynchronously(Runnable runnable) {
        this.threadExecutor.execute(runnable);
    }

    private static class CacheWriter implements Runnable {
        private final GetDaoSession getDaoSession;
        private final List<AutoEntity> autoEntities;

        private CacheWriter(GetDaoSession getDaoSession, List<AutoEntity> autoEntities) {
            this.getDaoSession = getDaoSession;
            this.autoEntities = autoEntities;
        }

        @Override
        public void run() {
            AutoEntityDao autoEntityDao = getDaoSession.getDaoSession().getAutoEntityDao();
            for (AutoEntity autoEntity : autoEntities) {
                autoEntityDao.insert(autoEntity);
            }
        }
    }
}
