package pe.com.plantilla.data.datasource.datastore;

import android.content.Context;

import pe.com.plantilla.data.datasource.cloud.store.CloudUsuarioDataStore;
import pe.com.plantilla.data.datasource.db.store.DbUsuarioDataStore;

public class UsuarioDataStoreFactory {

    public static final int DB = 1;
    public static final int CLOUD = 0;

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
