package com.example.root.dez.App;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by root on 09.12.16.
 */

public class MyApplication extends Application{
    private Realm realm;

    @Override
    public void onCreate() {

        super.onCreate();

        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
        realm = Realm.getDefaultInstance();
        realm.close();
        Realm.deleteRealm(realm.getConfiguration());



    }
}
