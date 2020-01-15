package pe.com.patadeperro.interactor.usuario;

import pe.com.patadeperro.domain.model.Usuario;

public interface UsuarioUpdatedCallback {

    void onUserUpdatedSuccess(Usuario usuario);

    void onUserUpdatedError(String message);
}
