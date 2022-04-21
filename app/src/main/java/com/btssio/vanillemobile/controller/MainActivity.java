package com.btssio.vanillemobile.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.btssio.vanillemobile.R;
import com.btssio.vanillemobile.model.Commande;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Commande commandeEnCours = Commande.getInstance();
        //
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        //
        String formattedDate = df.format(commandeEnCours.getDateCommande());
        //
        Toast toast = Toast.makeText(getApplicationContext(),"Affichage test de la commande " +formattedDate+ " montant de la commande "+String.valueOf(commandeEnCours.getTotalCommande()),Toast.LENGTH_LONG);
        toast.show();
    }
}