package br.com.crudandroidsturdio;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Consulta extends AppCompatActivity {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        CriarBancoController crud = new CriarBancoController(getBaseContext());
        Cursor cursor = crud.CarregaDados();

        String[] nomeCampos = new String[]{CriaBanco.ID,CriaBanco.TITULO};
        int[] idViews = new  int[]{R.id.idLivro,R.id.nomeLivro};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(getBaseContext(),
                R.layout.lista,cursor,nomeCampos,idViews,0);
        lista = (ListView)findViewById(R.id.listaLivros);
        lista.setAdapter(adapter);
    }
}
