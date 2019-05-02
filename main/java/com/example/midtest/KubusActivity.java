package com.example.midtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class KubusActivity extends AppCompatActivity {
    EditText Sisikubus;
    TextView tvHasil;

    Button btnhitung;
    double hasil;
    int sisikubusint;


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
        setContentView(R.layout.activity_kubus);
        Sisikubus = findViewById(R.id.sisikubus);
        tvHasil = findViewById(R.id.hasil);
        btnhitung = findViewById(R.id.hitungkubus);
        btnhitung.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view) {
                String sisikubus = Sisikubus.getText().toString();
                sisikubusint = Integer.parseInt(sisikubus);
                hasil = sisikubusint * sisikubusint * sisikubusint;
                tvHasil.setText(String.valueOf(hasil));
                Intent intent = new Intent(KubusActivity.this, ResultActivity.class);
                intent.putExtra("hasil_perhitungan", hasil);
                startActivity(intent);
            }
        });

    }

}