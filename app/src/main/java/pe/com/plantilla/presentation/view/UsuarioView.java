package pe.com.plantilla.presentation.view;

import pe.com.plantilla.domain.model.Usuario;

import java.util.ArrayList;

public interface UsuarioView extends BaseView {

    void userCreated(Usuario usuario);
    void userUpdated(Usuario usuario);
    void usersListLoaded(ArrayList<Usuario> usuarios);
    void showErrorMessage(String message);
}
