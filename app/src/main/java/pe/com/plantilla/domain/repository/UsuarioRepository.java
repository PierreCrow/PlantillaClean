package pe.com.plantilla.domain.repository;

import pe.com.plantilla.domain.model.Usuario;
import pe.com.plantilla.interactor.usuario.UsuarioCreatedCallback;
import pe.com.plantilla.interactor.usuario.UsuarioExistCallback;
import pe.com.plantilla.interactor.usuario.UsuarioListCallback;
import pe.com.plantilla.interactor.usuario.UsuarioUpdatedCallback;


public interface UsuarioRepository {

    void createUsuario(Usuario usuario, UsuarioCreatedCallback usuarioCreatedCallback);

    void verifyUserExist(String phone, UsuarioExistCallback usuarioExistCallback);

    void updateUsuario(Usuario usuario, UsuarioUpdatedCallback usuarioUpdatedCallback);

    void loadUsuarios(final UsuarioListCallback requestListCallback);

}
