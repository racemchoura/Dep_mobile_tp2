package com.example.racem_choura_mesure_glycmie.controller;

import com.example.racem_choura_mesure_glycmie.Model.Patient;
public final class Controller {
    private static Controller instance = null;
    private static Patient patient;
    private  Controller()
    {
        super();
    }
    public static  final Controller getInstance(){
        if(Controller.instance==null)
            Controller.instance = new Controller();
        return Controller.instance;
    }
    public void create_patient(int age ,float valeur , boolean isFasting){
        patient=new Patient(age,valeur,isFasting) ;
    }
    //update entre le controller vers la view
    public String getResult(){
        return patient.getResult();//update patient to controller
    }

}

