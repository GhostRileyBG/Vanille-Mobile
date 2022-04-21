package com.btssio.vanillemobile.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.btssio.vanillemobile.R;
import com.btssio.vanillemobile.model.Categorie;
import com.btssio.vanillemobile.model.Commande;
import com.btssio.vanillemobile.model.Produit;
import com.btssio.vanillemobile.repository.CatalogueRepository;

import java.time.LocalDate;
import java.util.HashMap;

public class ProduitActivity extends AppCompatActivity {
    //déclaration des attributs de la vue afin de faire le lien avec le fichier XML
    private EditText editQuantite;
    private TextView txtTitre;
    private TextView txtQuantite;
    private TextView txtPrixUnitaire;
    private TextView txtPrix;
    private Button btCalculer;
    private TextView txtTotal;
    private TextView txtTotalCalcule;
    private Button btAjouter;
    private Button btRetour;
    private Button btTerminer;
    //déclaration de la commande en cours
    private Commande commandeEnCours;
    //déclaration du produit sélectionné
    private Produit produitSelectionne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit);
        init();
    }

    private void init(){
        //lien avec les widgets de la vue
        editQuantite = findViewById(R.id.editQuantite);
        txtTitre = findViewById(R.id.txtTitre);
        txtQuantite = findViewById(R.id.txtQuantite);
        txtPrixUnitaire = findViewById(R.id.txtPrixUnitaire);
        txtPrix = findViewById(R.id.txtPrix);
        btCalculer = findViewById(R.id.btCalculer);
        txtTotal = findViewById(R.id.txtTotal);
        txtTotalCalcule = findViewById(R.id.txtTotalCalcule);
        btAjouter = findViewById(R.id.btAjouter);
        btRetour = findViewById(R.id.btRetour);
        btTerminer = findViewById(R.id.btTerminer);
        //récupération de la commande
        commandeEnCours = Commande.getInstance();
        //simulation de la selection du Produit
        //Categorie chocolats = new Categorie("cho", "Chocolats");
        //produitSelectionne = new Produit("B003", "Bonbons chocolat Lot 3 Kg"," ", (float)3.0,chocolats);

        //récupération du Produit sélectionné
        Bundle b = getIntent().getExtras();
        if(b != null){
            int pos = b.getInt("index");
            produitSelectionne = CatalogueRepository.RecupererLeCatalogue(this).get(pos);
        }

        //affichagedes informations sur le produit
        txtPrix.setText(String.valueOf(produitSelectionne.getPrixActuel(LocalDate.now())));
        txtTitre.setText(String.valueOf(produitSelectionne.getDescription()));
        //gestion du clic du bouton calculer
        btCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qte;
                float prix;
                qte = Integer.parseInt(editQuantite.getText().toString());
                prix = Float.valueOf(txtPrix.getText().toString());
                txtTotalCalcule.setText(String.valueOf(qte*prix));
            }
        });

        //gestion du clic du bouton Ajouter
        btAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int qte = Integer.parseInt(editQuantite.getText().toString());

                Toast.makeText(getApplicationContext(),"Ajout de " + editQuantite.getText().toString() + " " + txtTitre.getText().toString() + " à votre commande" ,Toast.LENGTH_LONG).show();

                HashMap<Produit, Integer> newprod = new HashMap<Produit, Integer>() ;
                newprod.put(produitSelectionne, qte);
                commandeEnCours.setLignesCommande(newprod);


                Log.i("ajouter", "onClick: ");
                Log.i("ajouter", commandeEnCours.toString());
            }
        });

        btTerminer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),FactureActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}