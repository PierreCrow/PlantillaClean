package pe.com.patadeperro.domain.repository;

import pe.com.patadeperro.domain.model.Usuario;
import pe.com.patadeperro.interactor.usuario.UsuarioCreatedCallback;
import pe.com.patadeperro.interactor.usuario.UsuarioExistCallback;
import pe.com.patadeperro.interactor.usuario.UsuarioListCallback;
import pe.com.patadeperro.interactor.usuario.UsuarioUpdatedCallback;


public interface UsuarioRepository {

    void createUsuario(Usuario usuario, UsuarioCreatedCallback usuarioCreatedCallback);

    void verifyUserExist(String phone, UsuarioExistCallback usuarioExistCallback);

    void updateUsuario(Usuario usuario, UsuarioUpdatedCallback usuarioUpdatedCallback);

    void loadUsuarios(final UsuarioListCallback requestListCallback);

}
