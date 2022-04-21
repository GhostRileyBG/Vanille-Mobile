package com.btssio.vanillemobile.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Catalogue {
    private String id;
    private String titre;
    private LocalDate dateEdition;
    private List<Produit> lesProduits;

  


    public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public LocalDate getDateEdition() {
		return dateEdition;
	}

	public void setDateEdition(LocalDate dateEdition) {
		this.dateEdition = dateEdition;
	}

	public List<Produit> getLesProduits() {
		return lesProduits;
	}

	public void setLesProduits(List<Produit> lesProduits) {
		this.lesProduits = lesProduits;
	}


	/**
	 *
	 * @param id
	 * @param titre
	 * @param dateEdition
	 */
    public Catalogue(String id, String titre, LocalDate dateEdition) {
		super();
		this.id = id;
		this.titre = titre;
		this.dateEdition = dateEdition;
		this.lesProduits = new ArrayList<Produit>();
	}

	/// <summary>
    /// Renvoie la liste des produits du catalogue appartenant � la cat�gorie recherch�e
    /// </summary>
    /// <param name="categorieRecherchee">cat�gorie recherch�e</param>
    /// <returns></returns>
    public List<Produit> getLesProduitsCategorie(Categorie categorieRecherchee){
    	List<Produit> listeCategorie = new ArrayList<Produit>();
    	for(Produit produitLu : lesProduits) {
    		if (produitLu.getCategorieDuProduit() == categorieRecherchee) {
    			listeCategorie.add(produitLu);
    		}
    		
    	}
    	return listeCategorie;
    }

    /// Renvoie une chaine correspondant au catalogue, les produits sont tri�s par ordre 
  ///alphab�tiques des descriptions
    public String stringCatalogue() {
    	String chaine = "Catalogue "+this.titre + " le "+ this.dateEdition+"\n\n";
    	Collections.sort(lesProduits);
    	for(Produit produitLu : lesProduits) {
    	     chaine += produitLu.toString(dateEdition)+"\n";
    	}
    	return chaine;
    }
    
    
 
	
	
	

}
