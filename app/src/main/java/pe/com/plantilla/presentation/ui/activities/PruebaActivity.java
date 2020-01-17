package pe.com.plantilla.presentation.ui.activities;

import android.content.Context;
import android.os.Bundle;

import com.com.patadeperro.R;

import java.util.ArrayList;

import pe.com.plantilla.domain.model.Usuario;
import pe.com.plantilla.presentation.presenter.UsuarioPresenter;
import pe.com.plantilla.presentation.view.UsuarioView;

public class PruebaActivity extends BaseActivity implements UsuarioView {


    UsuarioPresenter usuarioPresenter;
    Usuario usuario;



    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.prueba_activity);

        usuarioPresenter= new UsuarioPresenter();
        usuarioPresenter.addView(this);

        usuario= new Usuario("", "", "", "", "",
                0.0, 0.0, false,
        false, "", false);

        usuarioPresenter.createUsuario(usuario);

    }



    @Override
    public void userCreated(Usuario usuario) {

    }

    @Override
    public void userUpdated(Usuario usuario) {

    }

    @Override
    public void usersListLoaded(ArrayList<Usuario> usuarios) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public Context getContext() {
        return this;
    }
}