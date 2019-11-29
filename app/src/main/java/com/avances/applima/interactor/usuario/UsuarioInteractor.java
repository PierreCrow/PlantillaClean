package com.avances.applima.interactor.usuario;

import com.avances.applima.domain.model.Usuario;
import com.avances.applima.domain.repository.UsuarioRepository;

public class UsuarioInteractor {

    private final UsuarioRepository usuarioRepository;

    public UsuarioInteractor(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void createUsuario(Usuario usuario, UsuarioCreatedCallback usuarioCreatedCallback) {
        usuarioRepository.createUsuario(usuario, usuarioCreatedCallback);
    }

}
