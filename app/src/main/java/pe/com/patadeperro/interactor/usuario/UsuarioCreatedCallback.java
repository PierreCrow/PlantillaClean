package pe.com.patadeperro.interactor.usuario;

import pe.com.patadeperro.domain.model.Usuario;

public interface UsuarioCreatedCallback {

    void onUserCreatedSuccess(Usuario usuario);

    void onUserCreatedError(String message);
}
