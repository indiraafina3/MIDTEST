package com.example.midtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void KUBUS (View view) {
        Intent intent = new Intent(MainActivity.this, KubusActivity.class);
        startActivity(intent);
    }
    public void BOLA (View view) {
        Intent intent = new Intent(MainActivity.this, BolaActivity.class);
        startActivity(intent);
    }
    public void BALOK (View view) {
        Intent intent = new Intent(MainActivity.this, BalokActivity.class);
        startActivity(intent);
    }
}
