package pe.com.plantilla.interactor.usuario;

import pe.com.plantilla.domain.model.Usuario;

public interface UsuarioExistCallback {

    void onUserExistSuccess(Usuario user);

    void onUserCreatedError(String message);
}
