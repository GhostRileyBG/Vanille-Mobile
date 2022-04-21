package com.btssio.vanillemobile.model;

import java.io.Serializable;

public class Client implements Serializable {

        private String nomClient;
        private String prenomClient;
        private String adresseClient;
        private String cpClient;
        private String villeClient;
        private String mailClient;

        public Client(String nomClient, String prenomClient, String adresseClient, String cpClient, String villeClient, String mailClient) {
                this.nomClient = nomClient;
                this.prenomClient = prenomClient;
                this.adresseClient = adresseClient;
                this.cpClient = cpClient;
                this.villeClient = villeClient;
                this.mailClient = mailClient;
        }

        public String getNomClient() {
                return nomClient;
        }

        public void setNomClient(String nomClient) {
                this.nomClient = nomClient;
        }

        public String getPrenomClient() {
                return prenomClient;
        }

        public void setPrenomClient(String prenomClient) {
                this.prenomClient = prenomClient;
        }

        public String getAdresseClient() {
                return adresseClient;
        }

        public void setAdresseClient(String adresseClient) {
                this.adresseClient = adresseClient;
        }

        public String getCpClient() {
                return cpClient;
        }

        public void setCpClient(String cpClient) {
                this.cpClient = cpClient;
        }

        public String getVilleClient() {
                return villeClient;
        }

        public void setVilleClient(String villeClient) {
                this.villeClient = villeClient;
        }

        public String getMailClient() {
                return mailClient;
        }

        public void setMailClient(String mailClient) {
                this.mailClient = mailClient;
        }

        @Override
        public String toString() {
                return "Client{" +
                        "nomClient='" + nomClient + '\'' +
                        ", prenom='" + prenomClient + '\'' +
                        ", adresse='" + adresseClient + '\'' +
                        ", cpClient='" + cpClient + '\'' +
                        ", villeClient='" + villeClient + '\'' +
                        ", mailClient='" + mailClient + '\'' +
                        '}';
        }
}
