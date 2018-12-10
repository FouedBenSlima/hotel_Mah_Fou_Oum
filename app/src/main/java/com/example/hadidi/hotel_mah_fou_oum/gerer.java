package com.example.hadidi.hotel_mah_fou_oum;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class gerer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    //gerer
    EditText numchabre;
    RadioButton lib;
    RadioButton occup;
    EditText nomcl;
    EditText prenomcl;
    EditText cin;
    DatePicker deb;
    DatePicker fin;
    DB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        numchabre = findViewById(R.id.numchabre);
        nomcl = findViewById(R.id.nomcl);
        prenomcl = findViewById(R.id.prenomcl);
        cin = findViewById(R.id.cin);
        lib = findViewById(R.id.lib);
        occup = findViewById(R.id.occup);
        deb = findViewById(R.id.deb);
        fin = findViewById(R.id.fin);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gerer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_acc) {

            // Toast.makeText(this, "bonjour", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, page_Accueil.class);

            startActivity(intent);
        } else if (id == R.id.nav_con) {
            Intent intent = new Intent(this, consulte.class);

            startActivity(intent);

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void reserver(View view) {
        String num = numchabre.getText().toString();
        String nom = nomcl.getText().toString();
        String prenomt = prenomcl.getText().toString();
        String numcin = cin.getText().toString();
        String libre = lib.getText().toString();
        String occuper = occup.getText().toString();
        String debut = deb.toString();
        String finR = fin.toString();

        db = new DB(this);
        Boolean res = db.insertRes(numcin, num, libre, occuper, nom, prenomt, debut, finR);
        if (res == true) {
            Toast.makeText(this, "Ajoutation de chambre réussi", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, conselteChambre.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "eruer", Toast.LENGTH_SHORT).show();
        }
    }

    public void Annuler(View view) {
        Intent intent = new Intent(this, page_Accueil.class);
        startActivity(intent);
    }
}
