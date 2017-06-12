package com.gpriatmaja.pulsaku;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Laporan extends AppCompatActivity {
    String[] daftar;
    ListView contentlist;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static Laporan la;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);
        la=this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM penjualan",null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        contentlist = (ListView)findViewById(R.id.contentlist);
        contentlist.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        contentlist.setSelected(true);
        contentlist.setOnItemClickListener(new OnItemClickListener() {


            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Lihat Detail"};
                AlertDialog.Builder builder = new AlertDialog.Builder(Laporan.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                                Intent i = new Intent(getApplicationContext(), DetailLaporan.class);
                                i.putExtra("provider", selection);
                                startActivity(i);
                                                  }
                });
                builder.create().show();
            }
        });
            ((ArrayAdapter)contentlist.getAdapter()).notifyDataSetInvalidated();
        }
    }
