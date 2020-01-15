package pe.com.patadeperro.interactor.usuario;

import pe.com.patadeperro.domain.model.Usuario;

import java.util.List;

public interface UsuarioListCallback {

    void onUsersSuccess(List<Usuario> escortList);

    void onUsersError(String message);
}
