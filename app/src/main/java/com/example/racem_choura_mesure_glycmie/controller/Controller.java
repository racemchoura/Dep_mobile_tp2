package com.example.racem_choura_mesure_glycmie.controller;

import com.example.racem_choura_mesure_glycmie.Model.Patient;
public class Controller {
    private static Patient patient;
    public Controller()
    {
        super();
    }
    public void create_patient(int age ,float valeur , boolean isFasting){
        patient=new Patient(age,valeur,isFasting) ;
    }
    //update entre le controller vers la view
    public String getResult(){
        return patient.getResult();//update patient to controller
    }

}

