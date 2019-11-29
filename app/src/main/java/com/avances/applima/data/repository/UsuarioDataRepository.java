package com.avances.applima.data.repository;

import com.avances.applima.data.datasource.datastore.UsuarioDataStore;
import com.avances.applima.data.datasource.datastore.UsuarioDataStoreFactory;
import com.avances.applima.domain.model.Usuario;
import com.avances.applima.domain.repository.RepositoryCallback;
import com.avances.applima.domain.repository.UsuarioRepository;
import com.avances.applima.interactor.usuario.UsuarioCreatedCallback;

public class UsuarioDataRepository implements UsuarioRepository {

    private final UsuarioDataStoreFactory usuarioDataStoreFactory;

    public UsuarioDataRepository(UsuarioDataStoreFactory usuarioDataStoreFactory) {
        this.usuarioDataStoreFactory = usuarioDataStoreFactory;
    }

    @Override
    public void createUsuario(Usuario usuario, UsuarioCreatedCallback usuarioCreatedCallback) {
        final UsuarioDataStore usuarioDataStore = usuarioDataStoreFactory.create(usuarioDataStoreFactory.CLOUD);
        usuarioDataStore.createUsuario(usuario, new RepositoryCallback() {
            @Override
            public void onError(Object object) {
                String message = "";
                if (object != null) {
                    message = object.toString();
                }
                usuarioCreatedCallback.onUserCreatedError(message);
            }

            @Override
            public void onSuccess(Object object) {

                String message = (String) object;
                usuarioCreatedCallback.onUserCreatedSuccess(message);
            }
        });
    }

}
