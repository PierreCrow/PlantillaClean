package com.avances.applima.data.datasource.datastore;

import android.content.Context;

import com.avances.applima.data.datasource.cloud.store.CloudUsuarioDataStore;
import com.avances.applima.data.datasource.db.store.DbUsuarioDataStore;

public class UsuarioDataStoreFactory {

    public static final int DB = 1;
    public static final int CLOUD = 0;// Constants.SOURCE_TYPE.CLOUD;

    private final Context context;

    public UsuarioDataStoreFactory(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null!");
        }
        this.context = context.getApplicationContext();
    }


    public UsuarioDataStore create(int dataSource) {
        UsuarioDataStore usuarioDataStore = null;

        switch (dataSource) {
            case CLOUD:
                usuarioDataStore = createCloudDataStore();
                break;
            case DB:
                usuarioDataStore = new DbUsuarioDataStore(context);
                break;
        }
        return usuarioDataStore;
    }

    private UsuarioDataStore createCloudDataStore() {
        return new CloudUsuarioDataStore();
    }


}
