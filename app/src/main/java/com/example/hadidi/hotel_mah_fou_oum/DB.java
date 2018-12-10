package com.example.hadidi.hotel_mah_fou_oum;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 *
 */

public class DB extends SQLiteOpenHelper {


    public static final String DBname = "pr.db";

    public DB(Context context) {
        super(context, DBname, null, 30);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("PRAGMA foreign_keys=ON");
        db.execSQL("create table user ( login Text PRIMARY KEY,pwd TEXT,nom Text,prenom Text)");
        db.execSQL("create table chambr ( numch Text PRIMARY KEY,nmblit TEXT,prix Text)");
        db.execSQL("create table reservation (  cin Text PRIMARY KEY, numchabre Text,lib Text,occup Text,nomcl Text,prenomcl Text,deb Text,fin Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL("DROP TABLE IF EXISTS chambr");
        db.execSQL("DROP TABLE IF EXISTS reservation");
        onCreate(db);

    }

    public boolean insert(String login, String pwd, String nom, String prenom) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("login", login);
        contentValues.put("pwd", pwd);
        contentValues.put("nom", nom);
        contentValues.put("prenom", prenom);
        long result = db.insert("user", null, contentValues);
        return result != -1;
    }

    public boolean ajoute(String numch, String nmblit, String prix) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("numch", numch);
        contentValues.put("nmblit", nmblit);
        contentValues.put("prix", prix);
        long result = db.insert("chambr", null, contentValues);
        return result != -1;

    }


    public ArrayList getlogin(String logine, String pwdd) {

        ArrayList l1 = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select *  from user where login='" + logine + "' and +pwd='" + pwdd + "' ", null);

        res.moveToFirst();
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            String t1 = res.getString(res.getColumnIndex("login"));
            String t2 = res.getString(res.getColumnIndex("pwd"));
            l1.add(t1 + "\n" + t2);
            res.moveToNext();
        }
        return l1;

    }

    public boolean insertRes(String cin, String numchabre, String lib, String occup, String nomcl, String prenomcl, String deb, String fin) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("cin", cin);
        contentValues.put("numchabre", numchabre);
        contentValues.put("lib", lib);
        contentValues.put("occup", occup);
        contentValues.put("nomcl", nomcl);
        contentValues.put("prenomcl", prenomcl);
        contentValues.put("deb", deb);
        contentValues.put("fin", fin);

        long result = db.insert("reservation", null, contentValues);
        //


        return result != -1;

    }

    public ArrayList<Chambre> getRes() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from reservation ", null);
        ArrayList<Chambre> a1 = new ArrayList<Chambre>();
        Chambre e;
        res.moveToFirst();
        while (res.isAfterLast() == false) {
            e = new Chambre();
            //      e.setCin(res.getString(res.getColumnIndex("cin")));
            e.setNumchabre(res.getString(res.getColumnIndex("numchabre")));
          /*  e.setLib(res.getString(res.getColumnIndex("lib")));
            e.setOccup(res.getString(res.getColumnIndex("occup")));*/
            e.setNomcl(res.getString(res.getColumnIndex("nomcl")));
            /*e.setNumchabre(res.getString(res.getColumnIndex("prenomcl")));
            e.setDeb(res.getString(res.getColumnIndex("deb")));
            e.setFin(res.getString(res.getColumnIndex("fin")));*/
            a1.add(e);
            res.moveToNext();
        }

        return a1;
    }
}

