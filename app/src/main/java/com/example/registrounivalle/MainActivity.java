package com.example.registrounivalle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etApellido, etEmail, etCelular, etCodigoEstudiante;
    private Button btnRegistrar;
    private Switch swEstudiante;

    private String Nombre;
    private String Apellido;
    private String Celular;
    private String Email;

    private String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVistas();
        //visibilidad del elemento a ciew en pantalla y estpera un valor. ese calor ta lo tienenpreparada
        etCodigoEstudiante.setVisibility(View.GONE);
        //para un switch  checkbox
        //listener que este pendiente a los cambios en este componente
        swEstudiante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                habilitarCampoEstudiante(b);
                mostrarMensaje(b);
            }
        });


        btnRegistrar.setOnClickListener(view -> verificarCampos());
    }

    private void habilitarCampoEstudiante(boolean marcado) {
        if(marcado){
            etCodigoEstudiante.setVisibility(View.VISIBLE);
        }
        else
        {
            etCodigoEstudiante.setVisibility(View.GONE);
        }
    }

    private void mostrarMensaje(boolean marcado) {
        String mensaje = "no estoy marcado";
        if(marcado){
            mensaje = "Estoy marcado";
        }
        Toast.makeText(this,mensaje,Toast.LENGTH_SHORT).show();
    }

    private void inicializarVistas(){
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etEmail = findViewById(R.id.etEmail);
        etCelular = findViewById(R.id.etCelular);
        etCodigoEstudiante = findViewById(R.id.etCodigoEstudiante);
        btnRegistrar = findViewById(R.id.btnRegistrar);
        swEstudiante = findViewById(R.id.swEstudiante);
    }

    private void verificarCampos(){
        Nombre = etNombre.getText().toString();
        Apellido = etApellido.getText().toString();
        Email = etEmail.getText().toString();
        Celular = etCelular.getText().toString();
        if ((Nombre.equals("")) || (Apellido.equals("")))
        {
            mensaje = "llene todos sus datos";
            Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
        }else
        {
            mensaje = "nombre: "+Nombre+" apellido: "+Apellido+" email "+Email+" celular:" +Celular;
            Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show();
        }

    }



}