package com.avances.applima.presentation.view;

import com.avances.applima.domain.model.Usuario;

public interface UsuarioView extends BaseView {

    void userCreated(Usuario usuario);
    void showLoading();
    void hideLoading();
    void showErrorMessage(String message);
}
