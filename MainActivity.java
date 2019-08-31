package br.com.crudandroidsturdio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCadastrar = (Button)findViewById(R.id.btnCadastrar);

        Button btnConsultar = (Button)findViewById(R.id.btnConsultar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                CriarBancoController crud  = new CriarBancoController(getBaseContext());
                EditText txtTitulo = (EditText)findViewById(R.id.txtTitulo);
                EditText txtAutor = (EditText)findViewById(R.id.txtAutor);
                EditText txtEditora = (EditText)findViewById(R.id.txtEditora);

                String titulo = txtTitulo.getText().toString();
                String autor = txtAutor.getText().toString();
                String editora = txtEditora.getText().toString();

                String resultado = crud .InsereDados(titulo,autor,editora);

                Toast.makeText(getApplicationContext(),resultado,Toast.LENGTH_LONG).show();
            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Consulta.class);
                startActivity(intent);
            }
        });

    }
}
