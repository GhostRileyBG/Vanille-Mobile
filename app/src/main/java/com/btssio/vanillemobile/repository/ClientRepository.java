package com.btssio.vanillemobile.repository;

import android.content.Context;

import com.btssio.vanillemobile.model.Client;
import com.btssio.vanillemobile.outils.Serializer;

public abstract class ClientRepository {

    public static String getNomFichier() {
        return nomFichier;
    }

    private static final String nomFichier = "saveClient";

    public static void EnregistrerLeClient(Client leClient, Context context){
        Serializer.serialize(nomFichier, leClient, context);
    }

    public static Client RecupererLeClient(Context context){
        return (Client)Serializer.deSerialize(nomFichier,context);
    }

}
