package com.gpriatmaja.pulsaku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton pulsabt, paketanbt,listrikbt, laporanbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pulsabt = (ImageButton) findViewById(R.id.pulsabt);
        paketanbt = (ImageButton) findViewById(R.id.paketanbt);
        listrikbt = (ImageButton) findViewById(R.id.listrikbt);
        laporanbt = (ImageButton) findViewById(R.id.laporanbt);

        pulsabt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pulsa.class);
                startActivity(intent);
            }
        });

        paketanbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Paketan.class);
                startActivity(intent2);
            }
        });

        listrikbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), Listrik.class);
                startActivity(intent3);
            }
        });

        laporanbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), Laporan2.class);
                startActivity(intent4);
            }
        });
    }
}
