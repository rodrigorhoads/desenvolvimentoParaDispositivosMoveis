package br.com.crudandroidsturdio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "meubanco1.db";
    public   static  final  String TABELA="livros";
    public   static  final  String ID="_id";
    public static final  String TITULO="titulo";
    public static final String AUTOR="autor";
    public static final String EDITORA= "editora";
    private static final int VERSAO = 1;

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE "+TABELA+ "(" +
                ID +" integer primary key autoincrement," +
                TITULO+" text," +
                AUTOR+" text," +
                EDITORA+" text" +
                ")";
        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABELA);
        onCreate(sqLiteDatabase);
    }
}
