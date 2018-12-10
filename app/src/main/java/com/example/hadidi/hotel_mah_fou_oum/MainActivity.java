package com.example.hadidi.hotel_mah_fou_oum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    final String EXTRA_LOGIN = "user_login";
    final String EXTRA_PASSWORD = "user_password";
    EditText login;
    EditText pwd;
    DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login);
        pwd = findViewById(R.id.pwd);

        db = new DB(this);


    }

    public void Qite(View v) {
        finish();

    }

    public void navig(View view) {
        String loginText = login.getText().toString();
        String pwdText = pwd.getText().toString();
        ArrayList l2 = new ArrayList();
        l2 = db.getlogin(loginText, pwdText);
        int numberofitems = l2.size();


        if (numberofitems != 0) {

            Intent intent = new Intent(MainActivity.this, page_Accueil.class);
            intent.putExtra(EXTRA_LOGIN, loginText);
            intent.putExtra(EXTRA_PASSWORD, pwdText);
            startActivity(intent);


        } else
            Toast.makeText(MainActivity.this, R.string.email_or_password_empty, Toast.LENGTH_SHORT).show();

    }

    public void inscrit(View view) {
        Intent intent = new Intent(MainActivity.this, inscrit.class);
        startActivity(intent);
    }


}