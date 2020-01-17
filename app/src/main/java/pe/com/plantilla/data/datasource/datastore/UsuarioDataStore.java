package pe.com.plantilla.data.datasource.datastore;

import pe.com.plantilla.domain.model.Usuario;
import pe.com.plantilla.domain.repository.RepositoryCallback;

public interface UsuarioDataStore {

    void createUsuario(Usuario usuario, RepositoryCallback repositoryCallback);

    void updateUsuario(Usuario usuario, RepositoryCallback repositoryCallback);

    void verifyUsuarioExist(String phone, RepositoryCallback repositoryCallback);

    void usuariosList(RepositoryCallback repositoryCallback);

}
