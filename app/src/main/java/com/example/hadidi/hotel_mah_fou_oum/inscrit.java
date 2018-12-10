package com.example.hadidi.hotel_mah_fou_oum;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class inscrit extends AppCompatActivity {
    static int x = 1;
    EditText nom;
    EditText prenom;
    EditText login;
    EditText pwd;
    DB db;
    NotificationManager nmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrit);
        db = new DB(this);
        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        login = findViewById(R.id.emaile);
        pwd = findViewById(R.id.pwdd);

    }

    public void inscrits(View view) {
        String loginTxt = login.getText().toString();
        String passTxt = pwd.getText().toString();
        String nomTxt = nom.getText().toString();
        String prenomTxt = prenom.getText().toString();
        final String EXTRA_LOGIN = "user_login";
        final String EXTRA_PASSWORD = "user_password";


        if (loginTxt.equals("") && passTxt.equals("") && nomTxt.equals("") && prenomTxt.equals("")) {

            Toast.makeText(this, "Vous devez remplir touts les champs", Toast.LENGTH_SHORT).show();

        }
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        // On déclare un matcher, qui comparera le pattern avec la string passée en argument
        Matcher m = p.matcher(loginTxt);
        // Si l’adresse mail saisie ne correspond pas au format d’une adresse mail, on affiche un message à l'utilisateur
        if (!m.matches()) {
            Toast.makeText(this, R.string.email_format_error, Toast.LENGTH_SHORT).show();
            return;
        }


        Boolean res = db.insert(loginTxt, passTxt, nomTxt, prenomTxt);
        if (res == true) {

            Toast.makeText(this, "inscription réussi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(inscrit.this, page_Accueil.class);
            intent.putExtra(EXTRA_LOGIN, loginTxt);
            intent.putExtra(EXTRA_PASSWORD, passTxt);
            startActivity(intent);


            NotificationCompat.Builder nBuild = new NotificationCompat.Builder(this)
                    .setContentTitle("votre compte est crée")
                    .setContentText("Noblier pas votre code ")
                    .setSmallIcon(R.drawable.consulter);
            nmanager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            nmanager.notify(1, nBuild.build());
            x++;


        } else {
            Toast.makeText(this, "eruer", Toast.LENGTH_SHORT).show();
        }


    }


    public void Annuler(View view) {
        Intent intent = new Intent(inscrit.this, MainActivity.class);
        startActivity(intent);

    }
}
