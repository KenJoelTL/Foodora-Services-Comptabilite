/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.foodora.comptabilite.modele;

/**
 *
 * @author Joel
 */
public class Transaction {
    private int id;
    private int idSuccursale;
    private int idClient;
    private String date;
    private String items_commande;
    private double sousTotal;
    private double pourboireCoursier;

    public Transaction() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSuccursale() {
        return idSuccursale;
    }

    public void setIdSuccursale(int idSuccursale) {
        this.idSuccursale = idSuccursale;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItems_commande() {
        return items_commande;
    }

    public void setItems_commande(String items_commande) {
        this.items_commande = items_commande;
    }

    public double getSousTotal() {
        return sousTotal;
    }

    public void setSousTotal(double sousTotal) {
        this.sousTotal = sousTotal;
    }

    public double getPourboireCoursier() {
        return pourboireCoursier;
    }

    public void setPourboireCoursier(double pourboireCoursier) {
        this.pourboireCoursier = pourboireCoursier;
    }
    
    
    
    
    
}
