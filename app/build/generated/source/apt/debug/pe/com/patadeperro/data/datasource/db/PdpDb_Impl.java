package pe.com.patadeperro.data.datasource.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class PdpDb_Impl extends PdpDb {
  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Usuario` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `idCloud` TEXT, `uid` TEXT, `name` TEXT, `phoneNumber` TEXT, `email` TEXT, `lat` REAL, `lng` REAL, `logged` INTEGER NOT NULL, `active` INTEGER NOT NULL, `created_at` TEXT, `notifications` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"db817f467b977da4a22af0caf24eae1d\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Usuario`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUsuario = new HashMap<String, TableInfo.Column>(12);
        _columnsUsuario.put("id", new TableInfo.Column("id", "INTEGER", false, 1));
        _columnsUsuario.put("idCloud", new TableInfo.Column("idCloud", "TEXT", false, 0));
        _columnsUsuario.put("uid", new TableInfo.Column("uid", "TEXT", false, 0));
        _columnsUsuario.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsUsuario.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", false, 0));
        _columnsUsuario.put("email", new TableInfo.Column("email", "TEXT", false, 0));
        _columnsUsuario.put("lat", new TableInfo.Column("lat", "REAL", false, 0));
        _columnsUsuario.put("lng", new TableInfo.Column("lng", "REAL", false, 0));
        _columnsUsuario.put("logged", new TableInfo.Column("logged", "INTEGER", true, 0));
        _columnsUsuario.put("active", new TableInfo.Column("active", "INTEGER", true, 0));
        _columnsUsuario.put("created_at", new TableInfo.Column("created_at", "TEXT", false, 0));
        _columnsUsuario.put("notifications", new TableInfo.Column("notifications", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsuario = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsuario = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsuario = new TableInfo("Usuario", _columnsUsuario, _foreignKeysUsuario, _indicesUsuario);
        final TableInfo _existingUsuario = TableInfo.read(_db, "Usuario");
        if (! _infoUsuario.equals(_existingUsuario)) {
          throw new IllegalStateException("Migration didn't properly handle Usuario(pe.com.patadeperro.domain.model.Usuario).\n"
                  + " Expected:\n" + _infoUsuario + "\n"
                  + " Found:\n" + _existingUsuario);
        }
      }
    }, "db817f467b977da4a22af0caf24eae1d", "ba0c72963d23b669bc1ec22b51ffa734");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "Usuario");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `Usuario`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }
}
