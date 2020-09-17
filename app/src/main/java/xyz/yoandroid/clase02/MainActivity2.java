package xyz.yoandroid.clase02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private EditText nombre;
    private EditText email;
    private EditText telefono;
    private Button btn_enviar;
    private ListView listView;
    private List<String> Lista = new ArrayList<>();
    private ArrayAdapter<String> Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nombre = findViewById(R.id.nombre);
        email = findViewById(R.id.email);
        telefono = findViewById(R.id.telefono);
        btn_enviar = findViewById(R.id.btn_enviar);
        listView = findViewById(R.id.listview_datos);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombre_valor = nombre.getText().toString().trim();
                String email_valor = email.getText().toString().trim();
                String telefono_valor = telefono.getText().toString().trim();
                Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
                Matcher mather = pattern.matcher(email_valor);
                if(nombre_valor.equals("") || email_valor.equals("") || telefono_valor.equals("")){
                    Toast.makeText(MainActivity2.this, "Por favor rellene todos los datos correctamente!", Toast.LENGTH_LONG).show();
                }else{
                    if(mather.find() == false){
                        Toast.makeText(MainActivity2.this, "Ingrese un email correcto!", Toast.LENGTH_LONG).show();
                    }else{
                        if(telefono_valor.length() != 9){
                            Toast.makeText(MainActivity2.this, "Ingrese un numero valido!", Toast.LENGTH_LONG).show();
                        }else{
                            Lista.add("Nombre: " + nombre_valor + "\n" + "Email: " + email_valor + "\n" + "Telefono: " + telefono_valor);
                            Adapter = new ArrayAdapter<>(MainActivity2.this, android.R.layout.simple_list_item_1, Lista);
                            listView.setAdapter(Adapter);
                            nombre.getText().clear();
                            email.getText().clear();
                            telefono.getText().clear();
                            Toast.makeText(MainActivity2.this, "Informacion creada correctamente!", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        });
    }
}