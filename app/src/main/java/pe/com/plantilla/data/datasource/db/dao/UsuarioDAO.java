package pe.com.plantilla.data.datasource.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import pe.com.plantilla.domain.model.Usuario;

import java.util.ArrayList;


@Dao
public interface UsuarioDAO {

    @Insert
    void InsertOnlyOne(Usuario usuario);
    @Insert
    void InsertMultiple(ArrayList<Usuario> usuarios);
    @Update
    void Update(Usuario usuario);
    @Delete
    void Delete(Usuario usuario);

}
