package com.example.hadidi.hotel_mah_fou_oum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ajouterchmbre extends AppCompatActivity {
    EditText numch;
    EditText nbrlit;
    EditText prix;
    DB db;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouterchmbre);
        numch = findViewById(R.id.numch);
        nbrlit = findViewById(R.id.nbrch);
        prix = findViewById(R.id.prix);
        db = new DB(this);


    }


    public void anul(View view) {
        Intent intent = new Intent(this, page_Accueil.class);

        startActivity(intent);
    }

    public void ajouterCh(View view) {
        String num = numch.getText().toString();
        String nbr = nbrlit.getText().toString();
        String prx = prix.getText().toString();


        Boolean res = db.ajoute(num, nbr, prx);
        if (res == true) {
            Toast.makeText(this, "ajoutation de chambre réussi", Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(inscrit.this, page_Accueil.class);
            //startActivity(intent);

        } else {
            Toast.makeText(this, "eruer", Toast.LENGTH_SHORT).show();
        }

    }
}

