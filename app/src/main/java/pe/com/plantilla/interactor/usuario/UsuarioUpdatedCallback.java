package pe.com.plantilla.interactor.usuario;

import pe.com.plantilla.domain.model.Usuario;

public interface UsuarioUpdatedCallback {

    void onUserUpdatedSuccess(Usuario usuario);

    void onUserUpdatedError(String message);
}
