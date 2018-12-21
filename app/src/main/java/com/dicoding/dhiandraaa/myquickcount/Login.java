package com.dicoding.dhiandraaa.myquickcount;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username, password;
    Button btnLogin;
    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnLogin = (Button)findViewById(R.id.btnLogin);
        pref = getSharedPreferences("user_details",MODE_PRIVATE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();
                String subPassword1 = passwordKey.substring(0,8);
                String subPassword2 = passwordKey.substring(8,10);

                if (usernameKey.equals("admin") && passwordKey.equals("1234567890")){
                    //jika login berhasil
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("username",usernameKey);
                    editor.putString("password",subPassword1);
                    editor.putString("TPU",subPassword2);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "LOGIN SUKSES", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    Login.this.startActivity(intent);
                    finish();
                }else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setMessage("Username atau Password Anda salah!")
                            .setNegativeButton("Ulang", null).create().show();
            }
            }

        });
    }

    @Override
    public void onBackPressed () {
        super.onBackPressed();
        this.finish();
    }
}
