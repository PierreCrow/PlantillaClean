package com.avances.applima.domain.repository;

import com.avances.applima.domain.model.Usuario;
import com.avances.applima.interactor.usuario.UsuarioCreatedCallback;


public interface UsuarioRepository {

    void createUsuario(Usuario usuario, UsuarioCreatedCallback usuarioCreatedCallback);

}
