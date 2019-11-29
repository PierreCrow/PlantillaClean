package com.avances.applima.presentation.presenter;

import com.avances.applima.data.datasource.datastore.UsuarioDataStoreFactory;
import com.avances.applima.data.repository.UsuarioDataRepository;
import com.avances.applima.domain.repository.UsuarioRepository;
import com.avances.applima.interactor.usuario.UsuarioInteractor;
import com.avances.applima.presentation.view.UsuarioView;

public class UsuarioPresenter implements Presenter<UsuarioView> {

    private UsuarioView usuarioView;
    private UsuarioInteractor usuarioInteractor;


    @Override
    public void addView(UsuarioView view) {
        this.usuarioView = view;
        UsuarioRepository requestRepository = new UsuarioDataRepository(new UsuarioDataStoreFactory(this.usuarioView.getContext()));
        usuarioInteractor = new UsuarioInteractor(requestRepository);
    }

    @Override
    public void removeView(UsuarioView view) {

    }

}
