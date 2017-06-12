package com.gpriatmaja.pulsaku;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class DetailLaporan extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbCen;
    TextView providerTxt, noTxt, nominalTxt, hargaTxt;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_laporan);

        dbCen = new DataHelper(this);
        providerTxt = (TextView) findViewById(R.id.providerTxt);
        noTxt = (TextView) findViewById(R.id.noTxt);
        nominalTxt = (TextView) findViewById(R.id.nominalTxt);
        hargaTxt = (TextView) findViewById(R.id.hargaTxt);
        SQLiteDatabase db = dbCen.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM penjualan WHERE provider = '"+getIntent().getStringExtra("provider")+"'", null);
        cursor.moveToFirst();
        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            providerTxt.setText(cursor.getString(0).toString());
            noTxt.setText(cursor.getString(1).toString());
            nominalTxt.setText(cursor.getString(2).toString());
            hargaTxt.setText(cursor.getString(3).toString());
        }
    }
}
