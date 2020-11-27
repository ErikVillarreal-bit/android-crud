package com.example.crudsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudsqlite.utilidades.Utilidades;

public class Consultar_usuarios extends AppCompatActivity {

    EditText campoIdConsulta,campoNombreConsulta,campoTelefonoConsulta,campoDeporteConsulta;
    ConexionSQLiteHelper conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuarios);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_usuarios",null,1);

        campoIdConsulta=(EditText)findViewById(R.id.caja_id_consulta);
        campoNombreConsulta=(EditText)findViewById(R.id.caja_nombre_consulta);
        campoTelefonoConsulta=(EditText)findViewById(R.id.caja_telefono_consulta);
        campoDeporteConsulta = (EditText)findViewById(R.id.caja_deporte_consulta);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_buscar_registro:
                consultar();
                break;
            case R.id.btn_actualizar_registro:
                actualizar();
                break;
            case R.id.btn_borrar_registro:
                borrar();
                break;
        }
    }

    private void borrar() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {campoIdConsulta.getText().toString()};
        db.delete(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID+"=?",parametros);
        limpiar();
        Toast.makeText(getApplicationContext(),"Datos eliminados!!",Toast.LENGTH_LONG).show();
        db.close();
    }

    private void actualizar() {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {campoIdConsulta.getText().toString()};
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE, campoNombreConsulta.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, campoTelefonoConsulta.getText().toString());
        values.put(Utilidades.CAMPO_DEPORTE, campoDeporteConsulta.getText().toString());
        db.update(Utilidades.TABLA_USUARIO, values, Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Datos actualizados!!",Toast.LENGTH_LONG).show();
        db.close();
    }

    private void consultar() {
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {campoIdConsulta.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_TELEFONO,Utilidades.CAMPO_DEPORTE};

        try {
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoNombreConsulta.setText(cursor.getString(0));
            campoTelefonoConsulta.setText(cursor.getString(1));
            campoDeporteConsulta.setText(cursor.getString(2));
            cursor.close();
            Toast.makeText(getApplicationContext(),"Busqueda exitosa!!",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            limpiar();
            Toast.makeText(getApplicationContext(),"El usuario no existe!!",Toast.LENGTH_LONG).show();
        }


    }

    private void limpiar() {
        campoIdConsulta.setText("");
        campoNombreConsulta.setText("");
        campoTelefonoConsulta.setText("");
        campoDeporteConsulta.setText("");
    }
}