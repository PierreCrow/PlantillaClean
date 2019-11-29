package com.avances.applima.data.datasource.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.avances.applima.domain.model.Usuario;

@Database(entities = {
        Usuario.class},
        version =2 , exportSchema = false)

public abstract class AppLimaDb extends RoomDatabase {


    private static AppLimaDb INSTANCE;
    private static final String DB_NAME = "appLima.db";
    private static Context mContext;

    public static AppLimaDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppLimaDb.class) {
                if (INSTANCE == null) {
                    mContext=context.getApplicationContext();
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppLimaDb.class, DB_NAME)
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
