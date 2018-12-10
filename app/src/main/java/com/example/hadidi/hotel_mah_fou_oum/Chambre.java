package com.example.hadidi.hotel_mah_fou_oum;

public class Chambre {

    private String numchabre;
    private String lib;
    private String occup;
    private String nomcl;
    private String prenomcl;
    private String cin;
    private String deb;
    private String fin;

    public Chambre() {

    }

    public Chambre(String numchabre, String lib, String occup, String nomcl, String prenomcl, String cin, String deb, String fin) {

        this.numchabre = numchabre;
        this.lib = lib;
        this.occup = occup;
        this.nomcl = nomcl;
        this.prenomcl = prenomcl;
        this.cin = cin;
        this.deb = deb;
        this.fin = fin;
    }

    public String getNumchabre() {

        return numchabre;
    }

    public void setNumchabre(String numchabre) {
        this.numchabre = numchabre;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public String getOccup() {
        return occup;
    }

    public void setOccup(String occup) {
        this.occup = occup;
    }

    public String getNomcl() {
        return nomcl;
    }

    public void setNomcl(String nomcl) {
        this.nomcl = nomcl;
    }

    public String getPrenomcl() {
        return prenomcl;
    }

    public void setPrenomcl(String prenomcl) {
        this.prenomcl = prenomcl;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getDeb() {
        return deb;
    }

    public void setDeb(String deb) {
        this.deb = deb;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}
