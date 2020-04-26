package com.amirulhidayah.sqlliteregistrasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class register extends AppCompatActivity {
    DatabaseHelper db;
    EditText txtUsername, txtPassword, txtConfirmPassword;
    Button btnRegister;
    TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        txtUsername = (EditText)findViewById(R.id.registrasi_user);
        txtPassword = (EditText)findViewById(R.id.registrasi_password);
        txtConfirmPassword = (EditText)findViewById(R.id.registrasi_confirm_password);
        btnRegister = (Button)findViewById(R.id.btn_register);
        txtLogin = (TextView)findViewById(R.id.register_login);

        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(register.this,login.class);
                startActivity(intent);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = txtUsername.getText().toString().trim();
                String pwd = txtPassword.getText().toString().trim();
                String pwd_confirm = txtConfirmPassword.getText().toString().trim();

                if (pwd.equals(pwd_confirm)){
                    long val = db.addUser(user,pwd);
                    if (val > 0 ){
                        Toast.makeText(register.this,"Anda Berhasil Mendaftar",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(register.this,login.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(register.this,"Password Tidak Cocok",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
