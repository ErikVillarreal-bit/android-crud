package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudsqlite.utilidades.Utilidades;

public class RegistroUsuariosActivity extends AppCompatActivity {
    EditText campoId,campoNombre,campoTelefono,campoDeporte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuarios);

        campoId = (EditText)findViewById(R.id.caja_id_registro);
        campoNombre = (EditText)findViewById(R.id.caja_nombre_registro);
        campoTelefono = (EditText)findViewById(R.id.caja_telefono_registro);
        campoDeporte = (EditText)findViewById(R.id.caja_deporte_registro);
    }

    public void onClick(View view) {
        registrarUsuarios();
    }

    private void registrarUsuarios() {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios",null,1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID,campoId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());
        values.put(Utilidades.CAMPO_DEPORTE,campoDeporte.getText().toString());

        Long idResultante=db.insert(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID,values);
        Toast.makeText(getApplicationContext(), "Id Registro: "+idResultante, Toast.LENGTH_SHORT).show();
    }
}