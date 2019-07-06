package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultado;
    EditText num1, num2;
    double n1, n2, suma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.txtNumeroUno);
        num2 = findViewById(R.id.txtNumeroDos);
        resultado = findViewById(R.id.txtResultado);
    }

    public void calcular(View v)
    {
        n1 = Double.parseDouble(num1.getText().toString());
        n2 = Double.parseDouble(num2.getText().toString());
        suma = n1 + n2;
        resultado.setText(""+suma);
    }

}
