package com.gpriatmaja.pulsaku;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.provider.Telephony;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.jar.Manifest;

public class Listrik extends AppCompatActivity implements View.OnClickListener {
    private Spinner nominalls, hargasp;
    private EditText nomorEdit;
    private Button kirimbt;
    String provider, nominal, harga;
    DataHelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listrik);

        nominalls = (Spinner) findViewById(R.id.nominalls);
        hargasp = (Spinner) findViewById(R.id.hargasp);
        nomorEdit = (EditText) findViewById(R.id.nomorEdit);
        kirimbt = (Button) findViewById(R.id.kirimbt);

        kirimbt.setOnClickListener(this);


        nominalls.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nominal = nominalls.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        hargasp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                harga = hargasp.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        String no = "085378550440";
        String sms = nominal + "." + nomorEdit.getText().toString() + ".1234";

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("address", no);
        intent.putExtra("sms_body", sms);

        try {
            startActivity(intent);
        } catch (Exception ex) {
            Toast.makeText(Listrik.this, "Pengiriman SMS Gagal", Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }

        SQLiteDatabase db =  dbhelper.getWritableDatabase();
        db.execSQL("insert into pulsa (provider, nomer, nominal, harga) values ('" + provider + "','" +
                nomorEdit.getText().toString() + "','"+ nominal + "','"+harga + "')");
    }
}