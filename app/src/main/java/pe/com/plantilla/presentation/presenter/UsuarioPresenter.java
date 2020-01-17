package pe.com.plantilla.presentation.presenter;

import pe.com.plantilla.data.datasource.datastore.UsuarioDataStoreFactory;
import pe.com.plantilla.data.repository.UsuarioDataRepository;
import pe.com.plantilla.domain.model.Usuario;
import pe.com.plantilla.domain.repository.UsuarioRepository;
import pe.com.plantilla.interactor.usuario.UsuarioCreatedCallback;
import pe.com.plantilla.interactor.usuario.UsuarioExistCallback;
import pe.com.plantilla.interactor.usuario.UsuarioInteractor;
import pe.com.plantilla.interactor.usuario.UsuarioListCallback;
import pe.com.plantilla.interactor.usuario.UsuarioUpdatedCallback;
import pe.com.plantilla.presentation.view.UsuarioView;

import java.util.List;

public class UsuarioPresenter implements
        Presenter<UsuarioView>,
        UsuarioCreatedCallback,
        UsuarioExistCallback,
        UsuarioUpdatedCallback,
        UsuarioListCallback {

    private UsuarioView usuarioView;
    private UsuarioInteractor usuarioInteractor;


    public void createUsuario(Usuario usuario)
    {
        usuarioInteractor.createUsuario(
                usuario,this);
    }


    @Override
    public void addView(UsuarioView view) {
        this.usuarioView = view;
        UsuarioRepository requestRepository = new UsuarioDataRepository(new UsuarioDataStoreFactory(this.usuarioView.getContext()));
        usuarioInteractor = new UsuarioInteractor(requestRepository);
    }

    @Override
    public void removeView(UsuarioView view) {

    }

    @Override
    public void onUserCreatedSuccess(Usuario usuario) {
        usuarioView.userCreated(usuario);
    }

    @Override
    public void onUserExistSuccess(Usuario user) {

    }

    @Override
    public void onUserCreatedError(String message) {

    }

    @Override
    public void onUsersSuccess(List<Usuario> escortList) {

    }

    @Override
    public void onUsersError(String message) {

    }

    @Override
    public void onUserUpdatedSuccess(Usuario usuario) {

    }

    @Override
    public void onUserUpdatedError(String message) {

    }
}
