package com.avances.applima.data.datasource.datastore;

import com.avances.applima.domain.model.Usuario;
import com.avances.applima.domain.repository.RepositoryCallback;

public interface UsuarioDataStore {

    void createUsuario(Usuario usuario, RepositoryCallback repositoryCallback);

}
