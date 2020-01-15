package pe.com.patadeperro.interactor.usuario;

import pe.com.patadeperro.domain.model.Usuario;

public interface UsuarioExistCallback {

    void onUserExistSuccess(Usuario user);

    void onUserCreatedError(String message);
}
