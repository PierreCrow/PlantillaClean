package pe.com.plantilla.data.datasource.cloud.store;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import pe.com.plantilla.data.datasource.datastore.UsuarioDataStore;
import pe.com.plantilla.domain.model.Usuario;
import pe.com.plantilla.domain.repository.RepositoryCallback;
import pe.com.plantilla.presentation.utils.Constants;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.GeoPoint;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloudUsuarioDataStore implements UsuarioDataStore {
    private static final String TAG = "CloudUsuarioDataStore";

    private FirebaseFirestore db;

    public CloudUsuarioDataStore() {
        db = FirebaseFirestore.getInstance();
    }


    @Override
    public void createUsuario(Usuario usuario, RepositoryCallback repositoryCallback) {

        Map<String, Object> user = new HashMap<>();
        user.put("name", usuario.getName());

        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                        usuario.setIdCloud(documentReference.getId());
                        repositoryCallback.onSuccess(usuario);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        repositoryCallback.onError(e);
                    }
                });
    }

    @Override
    public void updateUsuario(Usuario usuario, RepositoryCallback repositoryCallback) {

        Map<String, Object> data = new HashMap<>();
        data.put("name", usuario.getName());


        db.collection("users").document(usuario.getIdCloud())
                .set(data, SetOptions.merge())
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        repositoryCallback.onSuccess(usuario);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                repositoryCallback.onError(e);
            }
        });
    }

    @Override
    public void verifyUsuarioExist(String phone, RepositoryCallback repositoryCallback) {


    }

    @Override
    public void usuariosList(RepositoryCallback repositoryCallback) {

    }
}
