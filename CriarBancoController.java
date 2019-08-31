package br.com.crudandroidsturdio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CriarBancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public CriarBancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public  String InsereDados(String titulo, String autor, String editora){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.TITULO,titulo);
        valores.put(CriaBanco.AUTOR,autor);
        valores.put(CriaBanco.EDITORA,editora);

        resultado = db.insert( CriaBanco.TABELA,null,valores);
        db.close();

        if(resultado ==- 1)
            return "Erro ao inserir os registros";
        else
            return "Registro inserido com sucesso";
    }

    public Cursor CarregaDados(){
        Cursor cursor;
        String [] campos = {banco.ID,banco.TITULO};

        db = banco.getReadableDatabase();

        cursor = db.query(banco.TABELA,campos,null,null,null,null,null,null);

        if(cursor!=null)
            cursor.moveToFirst();

        db.close();
        return cursor;
    }
}
