package com.gatito.agendasemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class confirmar extends AppCompatActivity {

    private TextView txt_nombre, txt_fecha, txt_telefono, txt_email, txt_descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);

        //Casting de las variables
        txt_nombre = (TextView)findViewById(R.id.txt_Nombre);
        txt_fecha = (TextView)findViewById(R.id.txt_Fecha);
        txt_telefono = (TextView)findViewById(R.id.txt_Telefono);
        txt_email = (TextView)findViewById(R.id.txt_Email);
        txt_descripcion = (TextView)findViewById(R.id.txt_Descripcion);

        //Recuperamos los datos del activity pasado
        String nombre = getIntent().getStringExtra("nombre");
        String telefono = getIntent().getStringExtra("telefono");
        String email = getIntent().getStringExtra("email");
        String descripcion = getIntent().getStringExtra("detalle");
        String fecha = getIntent().getStringExtra("FECHA");

        txt_nombre.setText(nombre);
        txt_telefono.setText(telefono);
        txt_email.setText(email);
        txt_descripcion.setText(descripcion);
        txt_fecha.setText(fecha);
    }

    //Metodo para regresar al activity principal y editar
    public void editar (View v){

        Intent editar = new Intent(this,MainActivity.class);
        editar.putExtra("nombreEditar",txt_nombre.getText().toString());
        editar.putExtra("telefonoEditar",txt_telefono.getText().toString());
        editar.putExtra("emailEditar",txt_email.getText().toString());
        editar.putExtra("detalleEditar",txt_descripcion.getText().toString());
        editar.putExtra("fechaEditar",txt_fecha.getText().toString());
        startActivity(editar);
        this.finish();

    }
}