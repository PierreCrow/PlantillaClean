package com.avances.applima.interactor.usuario;

public interface UsuarioCreatedCallback {

    void onUserCreatedSuccess(String message);

    void onUserCreatedError(String message);
}
