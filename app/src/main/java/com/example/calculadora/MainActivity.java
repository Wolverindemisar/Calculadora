package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView resultado;
    EditText num1, num2;
    double n1, n2, suma;
    String opciones[];
    Spinner combo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.txtNumeroUno);
        num2 = findViewById(R.id.txtNumeroDos);
        resultado = findViewById(R.id.txtResultado);
        combo = findViewById(R.id.cmbOperaciones);
        //Traemos las opciones de un array de Strings
        opciones = getResources().getStringArray(R.array.operaciones);

        // Creamos el adapter indicando, donde se va a colocar
        //como se va avisualizar y que se va a mostrar
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);

        //Pasamos el adapter al combo
        combo.setAdapter(adapter);
    }

    public void calcular(View v)
    {
        double res = 0;
        if(validar())
        {
            int opc;
            n1 = Double.parseDouble(num1.getText().toString());
            n2 = Double.parseDouble(num2.getText().toString());
            //suma = n1 + n2;
            opc = combo.getSelectedItemPosition();

            switch (opc) {
                case 0:
                    res = n1 + n2;
                    break;
                case 1:
                    res = n1 - n2;
                    break;
                case 2:
                    res = n1 * n2;
                    break;
                case 3:
                    res = n1 / n2;
                    break;
            }

            resultado.setText("" + res);
        }
    }

    public void Limpiar(View v)
    {
        num1.setText("");
        num2.setText("");
        resultado.setText("");
        combo.setSelection(0);
        combo.requestFocus();
    }

    public boolean validar()
    {
        int opc = combo.getSelectedItemPosition();
        if(num1.getText().toString().isEmpty())
        {
            num1.setError(getResources().getString(R.string.error_1));
            num1.requestFocus();
            return false;
        }
        else if(num2.getText().toString().isEmpty())
        {
            num2.setError(getResources().getString(R.string.error_2));
            num2.requestFocus();
            return false;
        }
        else if(Double.parseDouble(num2.getText().toString()) == 0 && opc == 3)
        {
            num2.setError(getResources().getString(R.string.error_3));
            num2.selectAll();
            return false;
        }

        return true;
    }

}
