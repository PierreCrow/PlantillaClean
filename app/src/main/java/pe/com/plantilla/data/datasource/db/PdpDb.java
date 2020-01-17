package pe.com.plantilla.data.datasource.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import pe.com.plantilla.domain.model.Usuario;

@Database(entities = {
        Usuario.class},
        version =2 , exportSchema = false)

public abstract class PdpDb extends RoomDatabase {


    private static PdpDb INSTANCE;
    private static final String DB_NAME = "plantilla.db";
    private static Context mContext;

    public static PdpDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PdpDb.class) {
                if (INSTANCE == null) {
                    mContext=context.getApplicationContext();
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PdpDb.class, DB_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries() // SHOULD NOT BE USED IN PRODUCTION !!!
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                   // Log.i(TAG, "populating with data...");
//                                    new PopulateDbAsync(INSTANCE).execute();
                                }
                            }).build();
                }
            }
        }
        return INSTANCE;
    }
}
