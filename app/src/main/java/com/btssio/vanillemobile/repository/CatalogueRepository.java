package com.btssio.vanillemobile.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;


import com.btssio.vanillemobile.model.Categorie;
import com.btssio.vanillemobile.model.Produit;
import com.btssio.vanillemobile.model.Promotion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class CatalogueRepository {

    public static List<Produit> RecupererLeCatalogue(Context context) {

        //simulation de récupération du catalogue
        List<Produit>  lesProduits = new ArrayList<>();
        Categorie bonbons = new Categorie("bon","Bonbons");
        Categorie chocolats = new Categorie("cho", "Chocolats");
        LocalDate date =  LocalDate.now();
        LocalDate debDate = LocalDate.now().minusDays(2);
        LocalDate finDate = LocalDate.now().plusDays(10);
        Produit produit1 = new Produit("B001", "Bonbons acidulés Lot 1 Kg"," ",(float)2.2, bonbons);
        Promotion promotion = new Promotion("hal", "Promotion pour Halloween", debDate, finDate, 0.2f);
        produit1.getLesPromos().add(promotion);
        lesProduits.add(produit1);
        Produit produit2 =new Produit("B002", "Bonbons glacés Lot 2 Kg" ," ",(float)4.4,bonbons);
        lesProduits.add(produit2);
        Produit produit3 = new Produit("B003", "Bonbons chocolat Lot 3 Kg"," ", (float)3.0,chocolats);
        lesProduits.add(produit3);
        Produit produit4=new Produit("B004", "Bonbons caramel Lot 4 Kg"," ", (float)5.0, bonbons);
        lesProduits.add(produit4);
        Produit  produit5 =new Produit("B005", "Bonbons acidulés Lot 5 Kg"," ", (float)1.0, bonbons);
        lesProduits.add(produit5);
        lesProduits.get(1).getLesPromos().add(promotion);


        return lesProduits;
    }



}
