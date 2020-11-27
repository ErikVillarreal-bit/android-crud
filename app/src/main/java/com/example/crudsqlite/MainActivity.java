package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios",null,1);
    }


    public void onClick(View view) {
        Intent miIntent = null;
        switch (view.getId()){
            case R.id.btnOpcionRegistro:
                miIntent = new Intent(MainActivity.this, RegistroUsuariosActivity.class);
                break;
            case R.id.btnOpcionConsulta:
                miIntent = new Intent(MainActivity.this, Consultar_usuarios.class);
                break;
            case R.id.btnOpcionConsultaLista:
                miIntent = new Intent(MainActivity.this, Consultar_usuarios_list_view.class);
                break;
        }
        if (miIntent != null){
            startActivity(miIntent);
        }
    }
}