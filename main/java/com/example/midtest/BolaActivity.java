package com.example.midtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BolaActivity extends AppCompatActivity {
    EditText Jarijaribola;
    TextView tvHasil;
    private static final double PI = 3.14;
    Button btnhitung;
    double hasil;
    int jarijaribolaint;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("hasil_hitung",hasil);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        double result = savedInstanceState.getDouble("hasil_hitung");
        tvHasil.setText(String.valueOf(result));
        hasil = result;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bola);
        Jarijaribola = findViewById(R.id.jarijaribola);
        tvHasil = findViewById(R.id.hasil);
        btnhitung = findViewById(R.id.hitungbola);
        btnhitung.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view) {
                String jarijaribola = Jarijaribola.getText().toString();
                jarijaribolaint = Integer.parseInt(jarijaribola);
                hasil = 4*PI*(jarijaribolaint * jarijaribolaint * jarijaribolaint)/3;
                tvHasil.setText(String.valueOf(hasil));
                Intent intent = new Intent(BolaActivity.this, ResultActivity.class);
                intent.putExtra("hasil_perhitungan", hasil);
                startActivity(intent);
            }
        });

    }

}