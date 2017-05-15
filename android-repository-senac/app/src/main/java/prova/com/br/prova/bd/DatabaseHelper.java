package prova.com.br.prova.bd;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CARINA on 08/05/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int VERSAO = 1;

    private static final String BD = "EMPRESA";

    public DatabaseHelper(Context context) {
        super(context, BD, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table empresa (" +
                "_id integer primary key," +
                "nome text," +
                "email text," +
                "faturamento double)");
        db.execSQL("create table bailao_teste (" +
                "_id integer primary key," +
                "titulo text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
