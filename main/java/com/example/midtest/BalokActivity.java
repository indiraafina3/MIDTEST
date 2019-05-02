package com.example.midtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BalokActivity extends AppCompatActivity {
    EditText Panjangbalok, Tinggibalok, Lebarbalok;
    TextView tvHasil;

    Button btnhitung;
    double hasil;
    int Panjangbalokint, Tinggibalokint, Lebarbalokint;


    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("hasil_hitung", hasil);
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
        setContentView(R.layout.activity_balok);
        Panjangbalok = findViewById(R.id.panjangbalok);
        Tinggibalok = findViewById(R.id.tinggibalok);
        Lebarbalok = findViewById(R.id.lebarbalok);
        tvHasil = findViewById(R.id.hasil);
        btnhitung = findViewById(R.id.hitungbalok);
        btnhitung.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                String panjangbalok = Panjangbalok.getText().toString();
                String lebarbalok = Lebarbalok.getText().toString();
                String tinggibalok = Tinggibalok.getText().toString();
                Panjangbalokint = Integer.parseInt(panjangbalok);
                Lebarbalokint = Integer.parseInt(lebarbalok);
                Tinggibalokint = Integer.parseInt(tinggibalok);
                hasil = Panjangbalokint * Lebarbalokint * Tinggibalokint;
                tvHasil.setText(String.valueOf(hasil));
                Intent intent = new Intent(BalokActivity.this, ResultActivity.class);
                intent.putExtra("hasil_perhitungan", hasil);
                startActivity(intent);
            }
        });

    }
}
