package com.example.isvirin.cleanapp.data.cache;

import android.content.Context;

import com.example.isvirin.cleanapp.data.entity.DaoMaster;
import com.example.isvirin.cleanapp.data.entity.DaoSession;

import org.greenrobot.greendao.database.Database;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GetDaoSession {
    public static final boolean ENCRYPTED = false;
    private DaoSession daoSession;

    @Inject
    public GetDaoSession(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, ENCRYPTED ? "shop-db-encrypted" : "shop-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
