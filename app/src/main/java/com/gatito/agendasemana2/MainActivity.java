package com.gatito.agendasemana2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Declaracion de variables
    static EditText edtxtNombre, edtxtTelefono, edtxtEmail, edtxtDescripcion, edtxtFecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Casting de las variables
        edtxtNombre = (EditText)findViewById(R.id.edtxt_Nombre);
        edtxtTelefono = (EditText)findViewById(R.id.edtxt_Telefono);
        edtxtEmail = (EditText)findViewById(R.id.edtxt_Email);
        edtxtDescripcion = (EditText)findViewById(R.id.edtxt_Descripcion);
        edtxtFecha = (EditText) findViewById(R.id.edtxt_Fecha);


        //Recuperación de variables para editar
        String nombre = getIntent().getStringExtra("nombreEditar");
        String telefono = getIntent().getStringExtra("telefonoEditar");
        String email = getIntent().getStringExtra("emailEditar");
        String detalle = getIntent().getStringExtra("detalleEditar");
        String fechaa = getIntent().getStringExtra("fechaEditar");

        edtxtNombre.setText(nombre);
        edtxtTelefono.setText(telefono);
        edtxtEmail.setText(email);
        edtxtDescripcion.setText(detalle);
        edtxtFecha.setText(fechaa);


    }

    //Metodo para el botón siguiente

    public void siguinte(View v){
        Intent siguiente = new Intent(this,confirmar.class);
        siguiente.putExtra("nombre",edtxtNombre.getText().toString());
        siguiente.putExtra("telefono",edtxtTelefono.getText().toString());
        siguiente.putExtra("email",edtxtEmail.getText().toString());
        siguiente.putExtra("detalle",edtxtDescripcion.getText().toString());
        siguiente.putExtra("FECHA",edtxtFecha.getText().toString());
        startActivity(siguiente);
        this.finish();
    }


    //Metodo para usar el Picker de fechas
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);


            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }


        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
            String fecha = day + "/" + month + "/" + year;
            edtxtFecha.setText(fecha);
        }
    }

    public void showDatePickerDialog(View v) {
        DatePickerFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
        }
    }