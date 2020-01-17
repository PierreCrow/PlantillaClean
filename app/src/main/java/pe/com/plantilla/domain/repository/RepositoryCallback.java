package pe.com.plantilla.domain.repository;

public interface RepositoryCallback {

    void onError(Object object);

    void onSuccess(Object object);
}
