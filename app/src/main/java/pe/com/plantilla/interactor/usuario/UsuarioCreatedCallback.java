package pe.com.plantilla.interactor.usuario;

import pe.com.plantilla.domain.model.Usuario;

public interface UsuarioCreatedCallback {

    void onUserCreatedSuccess(Usuario usuario);

    void onUserCreatedError(String message);
}
