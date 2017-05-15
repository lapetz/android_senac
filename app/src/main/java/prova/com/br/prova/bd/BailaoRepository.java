package prova.com.br.prova.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import prova.com.br.prova.domain.Bailao;

/**
 * Created by CARINA on 10/05/2017.
 */
public class BailaoRepository {

    private DatabaseHelper helper;

    private static final String TABLE = "bailao_teste";

    public BailaoRepository(Context context) {
        helper = new DatabaseHelper(context);
    }

    public void close() {
        helper.close();
    }

    public long salvar(Bailao empresa) {
        SQLiteDatabase db = helper.getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("titulo", empresa.getTitulo());
            return db.insert(TABLE, null, values);
        }
        finally {
            db.close();
        }
    }

    public List<String> findNomeEmpresas() {
        SQLiteDatabase db = helper.getReadableDatabase();
        try {
            String sql = String.format("select titulo from %s order by nome", TABLE);
            Cursor cursor = db.rawQuery(sql, null);
            cursor.moveToFirst();
            List<String> nomes  = new ArrayList<>();
            while (!cursor.isAfterLast()) {
                nomes.add(cursor.getString(0)); //primeira coluna
                cursor.moveToNext();
            }
            return nomes;
        } finally {
            db.close();
        }
    }
}
