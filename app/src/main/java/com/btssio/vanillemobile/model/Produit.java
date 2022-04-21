package com.btssio.vanillemobile.model;



import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Produit implements Comparable<Produit>{
    private String id;
    private String description;
    private float prix;
    private String image; //chemin du fichier
    private Categorie categorieDuProduit;
    private List<Promotion> lesPromos;



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Categorie getCategorieDuProduit() {
        return categorieDuProduit;
    }

    public void setCategorieDuProduit(Categorie categorieDuProduit) {
        this.categorieDuProduit = categorieDuProduit;
    }

    public List<Promotion> getLesPromos() {
        return lesPromos;
    }

    public void setLesPromos(List<Promotion> lesPromos) {
        this.lesPromos = lesPromos;
    }


    @Override
    public String toString() {

        return toString(LocalDate.now()) ;
    }




    /// <summary>
    /// Renvoie la première promotion trouvée correspondant à la date passée en paramètre
    /// Renvoie null s’il n’existe pas de promotion pour cette date
    /// </summary>
    /// <param name="date">date recherchée</param>
    /// <returns>Promotion en cours ou null</returns>


    public Promotion getPromo(LocalDate date)
    {
        Promotion promotionTrouvee = null;
        int i = 0;
        while ((i < lesPromos.size()) && (promotionTrouvee == null))
        {
            if ((lesPromos.get(i).getDebutPromo().compareTo(date) <= 0) && (lesPromos.get(i).getFinPromo().compareTo(date) >= 0))
                promotionTrouvee = lesPromos.get(i);
            i++;
        }
        return promotionTrouvee;
    }
    /// <summary>
    /// renvoie l'id la description et le prix du produit correspondant à la date
    /// affiche le prix promotionnel suivi du mot PROMO lorsque le produit est en promotion
    /// </summary>
    /// <param name="date">date de prise en compte du prix du produit</param>
    /// <returns>chaine représentant le produit</returns>

    public String toString(LocalDate date)
    {
        String chaine = description ;
        if (this.getPromo(date) != null)
        {
            chaine += " " + String.format("%.2f",prix * (1 - this.getPromo(date).getRemise())) + " euros"+ " PROMO";

        }
        else
        {
            chaine += " " +String.format("%.2f", prix)+ " euros";
        }

        return chaine;
    }



    @Override
    public int compareTo(Produit o) {

        return description.compareTo(o.description);
    }

    public Produit(String id, String description, String image, float prix, Categorie categorieDuProduit) {
        super();
        this.id = id;
        this.description = description;
        this.prix = prix;
        this.image = image;
        this.categorieDuProduit = categorieDuProduit;
        this.lesPromos = new ArrayList<Promotion>();
    }

    public float getPrixActuel(LocalDate date){
       float prixActuel = prix;
        if (this.getPromo(date) != null) {
            prixActuel = prix * (1 - this.getPromo(date).getRemise());
        }
          return prixActuel;
    }

}
