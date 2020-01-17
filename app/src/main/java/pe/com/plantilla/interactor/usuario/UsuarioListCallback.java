package pe.com.plantilla.interactor.usuario;

import pe.com.plantilla.domain.model.Usuario;

import java.util.List;

public interface UsuarioListCallback {

    void onUsersSuccess(List<Usuario> escortList);

    void onUsersError(String message);
}
