package com.huaraz.luis.apphuaraz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tienda4 extends AppCompatActivity {

    Button comprar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tienda4);

        comprar =(Button)findViewById(R.id.comprar);

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in  = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(in);
                Toast.makeText(getApplicationContext(), "Se Registro el Pedido, Revisar su correo",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
