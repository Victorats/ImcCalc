package com.example.imc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class relatorio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_relatorio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent it = getIntent();
        Bundle params = it.getExtras();
        if (params != null) {
            double altura = 0.0, peso = 0.0, imc = 0.0;
            String nome = "", classificacao = "";
            int idade = 0;

            altura = params.getDouble("altura");
            peso = params.getDouble("peso");
            imc = calculaImc(altura, peso);
            classificacao = classificaImc(imc);
            nome = params.getString("nome");
            idade = params.getInt("idade");

            ((TextView) findViewById(R.id.nomeEntrada)).setText(nome);
            ((TextView) findViewById(R.id.idadeEntrada)).setText(String.valueOf(idade));
            ((TextView) findViewById(R.id.pesoEntrada)).setText(String.format("%.2f", peso));
            ((TextView) findViewById(R.id.alturaEntrada)).setText(String.format("%.2f", altura));
            ((TextView) findViewById(R.id.imcEntrada)).setText(String.format("%.2f", imc));
            ((TextView) findViewById(R.id.classEntrada)).setText(classificacao);
        }
    }

    protected double calculaImc(double altura, double peso){
        altura = altura/100;
        double imc = peso/(altura*altura);
        return imc;
    }
    protected String classificaImc(double imc){
        String classificacao = "";
        if(imc < 18.5){
            classificacao = "Abaixo do peso";
        }else if(imc < 25){
            classificacao = "Saudável";
        }else if(imc < 30){
            classificacao = "Sobrepeso";
        }
        else if(imc < 35){
            classificacao = "Obesidade Grau I";
        }
        else if(imc < 40){
            classificacao = "Obesidade Grau II (severa)";
        }
        else{
            classificacao = "Obesidade Grau III (mórbida)";
        }
        return classificacao;
    }
    public void navegarTelaPrincipal(View v){

        this.finish();

        Intent it = new Intent(this, MainActivity.class);

        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        startActivity(it);


    }

}