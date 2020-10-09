package com.programacionfacil.miappparte2rbl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Comunicacion1 extends AppCompatActivity {
    EditText edtnombre;
    EditText edtingresomes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunicacion1);
        edtnombre=findViewById(R.id.edtnombre);
        edtingresomes=findViewById(R.id.edtingresomes);
    }
    public void Verificar(View view){
        if(edtnombre.getText().length()!=0 && edtingresomes.getText().length()!=0){
        Intent intent = new Intent(this, Comunicacion2.class);
        intent.putExtra("nombre", edtnombre.getText().toString());
        intent.putExtra("ingresomes", Integer.parseInt(edtingresomes.getText().toString()));
        startActivityForResult(intent, 1234);
        }else{
            Toast.makeText(this,"Debes ingresar un nombre y un ingreso mensual",Toast.LENGTH_LONG).show();
        }
   }
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView miresultado = findViewById(R.id.txtvalor);
        if (requestCode == 1234 && resultCode == RESULT_OK) {
            String res = data.getExtras().getString("resultado");
            if (res.equals("aceptado"))
                miresultado.setText("Esperamos que trabajar con nosotros sea de su agrado");
            else
                miresultado.setText("Esperemos que cambie de opinion para trabajar con nosotros");
        }
        if (requestCode == 3500 && resultCode == RESULT_OK) {
            miresultado.setText("Visitenos en alguna de nuestras sucursales");
        }
    }
    public void sucursales(View view) {
        startActivityForResult(new Intent(this, Comunicacion3.class), 3500);
    }

}