package com.gpriatmaja.pulsaku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText loginTxt;
    Button loginbt;
    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbt = (Button) findViewById(R.id.loginbt);

        loginbt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        loginTxt = (EditText) findViewById(R.id.loginEdit);
        txt = loginTxt.getText().toString();
        if (txt.contains("1234")){
            Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this, MainActivity.class);
            startActivity(intent);
        }

        else if (txt.matches("")){
            Toast.makeText(this, "Isi Password", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
        }
    }
}
