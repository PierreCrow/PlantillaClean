package com.avances.applima.data.datasource.cloud.store;

import com.avances.applima.data.datasource.cloud.apiclient.ApiClient;
import com.avances.applima.data.datasource.cloud.apiclient.ApiClientInterface;
import com.avances.applima.data.datasource.datastore.UsuarioDataStore;
import com.avances.applima.domain.model.Usuario;
import com.avances.applima.domain.repository.RepositoryCallback;

public class CloudUsuarioDataStore implements UsuarioDataStore {
    private static final String TAG = "CloudUsuarioDataStore";

    private ApiClientInterface apiClientInterface;

    public CloudUsuarioDataStore() {
        apiClientInterface = ApiClient.getApiClient();
    }


    @Override
    public void createUsuario(Usuario usuario, RepositoryCallback repositoryCallback) {

    }
}
