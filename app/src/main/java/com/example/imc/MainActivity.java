package com.example.imc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void onClickButtonRel(View view){

        Bundle params = new Bundle();

        params.putString("nome", ((EditText)findViewById(R.id.caixaNome)).getText().toString());
        params.putInt("idade", Integer.parseInt(((EditText)findViewById(R.id.caixaIdade)).getText().toString()));
        params.putDouble("peso", Double.parseDouble(((EditText)findViewById(R.id.caixaPeso)).getText().toString()));
        params.putDouble("altura", Integer.parseInt(((EditText)findViewById(R.id.caixaAltura)).getText().toString()));
        Intent it = new Intent(getBaseContext(), relatorio.class);

        it.putExtras(params);
        startActivity(it);

    }


}