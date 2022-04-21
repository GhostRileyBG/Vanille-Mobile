package com.btssio.vanillemobile.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.btssio.vanillemobile.R;
import com.btssio.vanillemobile.model.Produit;
import com.btssio.vanillemobile.repository.CatalogueRepository;

import java.util.ArrayList;
import java.util.List;

public class ListeProduitsActivity extends AppCompatActivity {

    private ListView lv_produits;
    private List<Produit> lesProduits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits);

        init();
    }

    private void init(){
        lv_produits = findViewById(R.id.lv_produits);
        lesProduits = CatalogueRepository.RecupererLeCatalogue(this);
        ArrayAdapter<Produit> itemsAdapter = new ArrayAdapter<Produit>(this, android.R.layout.simple_list_item_1, lesProduits);
        lv_produits.setAdapter(itemsAdapter);

        lv_produits.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l){
                Intent intent = new Intent(ListeProduitsActivity.this, ProduitActivity.class);
                intent.putExtra("index",position);
                startActivity(intent);
            }
        });
    }

}