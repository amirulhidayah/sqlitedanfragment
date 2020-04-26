package com.amirulhidayah.sqlliteregistrasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    DatabaseHelper db;
    EditText loginUsername, loginPassword;
    Button btnLogin;
    TextView txtDaftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.btn_login);
        txtDaftar = (TextView) findViewById(R.id.login_signup);

        txtDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,register.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = loginUsername.getText().toString().trim();
                String password = loginPassword.getText().toString().trim();
                Boolean res = db.CheckUser(user,password);

                if (res == true){
                    Toast.makeText(login.this, "Anda Berhasil Masuk", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(login.this,fragment.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(login.this, "Username atau Password anda Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
