package com.example.racem_choura_mesure_glycmie.Model;

public class Patient {
    private int age;
    private float valeur;
    private boolean Isfasting;
    private String result;
    public Patient (int age ,float valeur, boolean Isfasting) {
        this.Isfasting = Isfasting;
        this.valeur = valeur;
        this.age = age;
        calculer();
    }
    public int getAge(){
        return age;
    }
    public float getValeur(){
        return valeur;
    }
    public boolean Isfasting(){
        return Isfasting;
    }
    public String getResult(){ return result;}
    public void calculer(){
        if (Isfasting) {
            if (age >= 13) {
                if (valeur < 5)
                    result="viveau de glycémie bas";
                else if (valeur >= 5 && valeur <= 7.2)
                   result="Niveau de glycémie est normale";
                else
                    result="Niveau de glycémie est elevé";
            } else if (age >= 6 && age <= 12) {
                if (valeur < 5)
                    result="viveau de glycémie bas";
                else if (valeur >= 5 && valeur <= 10)
                    result="Niveau de glycémie est normale";
                else
                    result="Niveau de glycémie est elevé";
            } else if (age < 6) {
                if (valeur < 5.5)
                    result="viveau de glycémie bas";
                else if (valeur >= 55 && valeur <= 10.0)
                    result="Niveau de glycémie est normale";
                else
                    result="Niveau de glycémie est elevé";
            } else {
                //false
                if (valeur > 10.5)
                    result="Niveau de glycémie est elevé";
                else
                    result="Niveau de glycémie est normale";
            }
        }

    }
}


