package pe.com.plantilla.data.repository;

import pe.com.plantilla.data.datasource.datastore.UsuarioDataStore;
import pe.com.plantilla.data.datasource.datastore.UsuarioDataStoreFactory;
import pe.com.plantilla.domain.model.Usuario;
import pe.com.plantilla.domain.repository.RepositoryCallback;
import pe.com.plantilla.domain.repository.UsuarioRepository;
import pe.com.plantilla.interactor.usuario.UsuarioCreatedCallback;
import pe.com.plantilla.interactor.usuario.UsuarioExistCallback;
import pe.com.plantilla.interactor.usuario.UsuarioListCallback;
import pe.com.plantilla.interactor.usuario.UsuarioUpdatedCallback;

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

                Usuario newUser = (Usuario) object;
                usuarioCreatedCallback.onUserCreatedSuccess(newUser);
            }
        });
    }

    @Override
    public void verifyUserExist(String phone, UsuarioExistCallback usuarioExistCallback) {

    }

    @Override
    public void updateUsuario(Usuario usuario, UsuarioUpdatedCallback usuarioUpdatedCallback) {

    }

    @Override
    public void loadUsuarios(UsuarioListCallback requestListCallback) {

    }

}
