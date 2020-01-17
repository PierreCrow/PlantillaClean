package pe.com.plantilla.interactor.usuario;

import pe.com.plantilla.domain.model.Usuario;
import pe.com.plantilla.domain.repository.UsuarioRepository;

public class UsuarioInteractor {

    private final UsuarioRepository usuarioRepository;

    public UsuarioInteractor(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void createUsuario(Usuario usuario, UsuarioCreatedCallback usuarioCreatedCallback) {
        usuarioRepository.createUsuario(usuario, usuarioCreatedCallback);
    }

}
