package xyz.yoandroid.clase02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn_factorial;
    private TextView numero;
    /////////////

    private Button btn_enviar;
    private EditText nombre;
    private EditText correo;
    private EditText telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = findViewById(R.id.text1);
        btn_factorial = findViewById(R.id.btn1);
        btn_factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(numero.getText().toString());
                Toast.makeText(MainActivity.this, "El resultado es: " + factorial(a) , Toast.LENGTH_LONG).show();
            }
        });



    }

    public int factorial(int numero){
        int factorial = 1;
        for (int x=1;x<=numero;x++){
            factorial = factorial * x;
        }
        return factorial;
    }

}