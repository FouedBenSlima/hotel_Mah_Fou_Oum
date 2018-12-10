package com.example.hadidi.hotel_mah_fou_oum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class conselteChambre extends AppCompatActivity {
    DB db = new DB(this);
    Button closeBtn;
    ListView l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conselte_chambre);

        l1 = findViewById(R.id.list_e);
        ArrayList<Chambre> v = db.getRes();

        ChmbreAdap adap = new ChmbreAdap(this, R.layout.item_row, v);
        l1.setAdapter(adap);


    }
}
