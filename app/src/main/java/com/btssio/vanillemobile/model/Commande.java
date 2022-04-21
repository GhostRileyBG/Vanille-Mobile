package com.btssio.vanillemobile.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public final class Commande {

    private static Commande instance = null;
    private int id;
    private Long dateCommande;
    private Client leClient;
    private HashMap<Produit, Integer> lignesCommande = new HashMap<Produit, Integer>() ;


    private Commande( Long dateCommande) {

        this.dateCommande = dateCommande;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Long dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Client getLeClient() {
        return leClient;
    }

    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }

    public HashMap<Produit, Integer> getLignesCommande() {
        return lignesCommande;
    }

    public void setLignesCommande(HashMap<Produit, Integer> lignesCommande) {
        this.lignesCommande = lignesCommande;
    }

    public float getTotalCommande(){
        float total = (float) 0.0;
        for(Map.Entry<Produit,Integer> entry : lignesCommande.entrySet()){
            total += (float) (entry.getValue() * (entry.getKey().getPrixActuel(LocalDate.now())));
        }
        return total;
    }

    public final static Commande getInstance(){
        //Le "Double-Checked Singelton"/"Singelton doublement vérifié" permet d'éviter un appel coûteux à synchronizé, une fois que l'instanciation est faite.
        if (Commande.instance == null){
            synchronized(Commande.class){
                if(Commande.instance == null){
                    Commande.instance = new Commande(new java.util.Date().getTime());
                }
            }
        }
        return Commande.instance;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id=" + id +
                ", dateCommande=" + dateCommande +
                ", leClient=" + leClient +
                ", lignesCommande=" + lignesCommande +
                '}';
    }
}
