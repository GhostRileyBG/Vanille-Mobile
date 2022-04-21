package com.btssio.vanillemobile.model;

public class Categorie {
    private String id;
    private String libelle;
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public Categorie(String id, String libelle) {
        super();
        this.id = id;
        this.libelle = libelle;
    }



}
