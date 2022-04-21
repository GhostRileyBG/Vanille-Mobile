package com.btssio.vanillemobile.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.btssio.vanillemobile.R;
import com.btssio.vanillemobile.model.Client;
import com.btssio.vanillemobile.model.Commande;
import com.btssio.vanillemobile.outils.Serializer;
import com.btssio.vanillemobile.repository.ClientRepository;

public class FactureActivity extends AppCompatActivity {

    //déclaration des editText permettant de récupérer la saisie de l'utilisateur
    private EditText editNom;
    private EditText editPrenom;
    private EditText editAdresse;
    private EditText editCP;
    private EditText editVille;
    private EditText editMail;
    private Button btModifier;
    private Button btEnvoyer;
    private Button btAnnuler;

    private Commande commandeEnCours;

    //zone d'affichage du montant de la facture
    private TextView txtMontant;

    private void init(){
        commandeEnCours = Commande.getInstance();
        editAdresse = findViewById(R.id.editAdresse);
        editCP = findViewById(R.id.editCodePostal);
        editMail = findViewById(R.id.editMail);
        editNom = findViewById(R.id.editNom);
        editPrenom = findViewById(R.id.editPrenom);
        editVille = findViewById(R.id.editVille);
        txtMontant = findViewById(R.id.txtMontant);
        btEnvoyer = findViewById(R.id.btEnvoyer);
        txtMontant.setText(String.valueOf(commandeEnCours.getTotalCommande()));
        btAnnuler = findViewById(R.id.btAnnuler);
        btModifier = findViewById(R.id.btModifier);
        final Context context = this;
        recupClient();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facture);
        init();
        btEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //création d'un client
                //à vous de jouer
                Client client1 = new Client (String.valueOf(editNom.getText()), String.valueOf(editPrenom.getText()), String.valueOf(editAdresse.getText()), String.valueOf(editCP.getText()), String.valueOf(editVille.getText()), String.valueOf(editMail.getText()));
                ClientRepository.EnregistrerLeClient(client1, FactureActivity.this);

                //ajout du client à la commande
                commandeEnCours.setLeClient(client1);

                //créer un Toast et le lancer
                //Toast.makeText(context,text,duration).show();
                //à vous de jouer...
                Toast toast = Toast.makeText(getApplicationContext(),"Votre commande d'un montant de " +txtMontant.getText()+ " a bien ete envoye ! vous recevrez un mail de confirmation a l'adresse "+editMail.getText(),Toast.LENGTH_LONG);
                toast.show();

                Log.i("envoyer","onClick "+ commandeEnCours.getLeClient().toString());
            }
        });

        btAnnuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FactureActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void recupClient(){
        if (null != Serializer.deSerialize(ClientRepository.getNomFichier(),this)){
            Client leClient = (Client)Serializer.deSerialize(ClientRepository.getNomFichier(),this);
            editNom.setText(leClient.getNomClient());
            editPrenom.setText(leClient.getPrenomClient());
            editAdresse.setText(leClient.getAdresseClient());
            editCP.setText(leClient.getCpClient());
            editVille.setText(leClient.getVilleClient());
            editMail.setText(leClient.getMailClient());
        }
    }

}