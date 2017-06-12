package com.gpriatmaja.pulsaku;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Galih on 5/31/2017.
 */
public class DataHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "penjualan.db";
    private static final int DATABASE_VERSION = 1;
    public DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table penjualan(no integer primary key, provider text null, nomer text null, nominal text null, harga text null)";
        Log.d("Data", "onCreate: " + sql);
        sql = "INSERT INTO penjualan (provider, nomer, nominal, harga) VALUES ('XL', '08785504405', '5000','6000');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
