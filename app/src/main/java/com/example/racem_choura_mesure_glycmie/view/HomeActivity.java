package com.example.racem_choura_mesure_glycmie.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.racem_choura_mesure_glycmie.R;
import com.example.racem_choura_mesure_glycmie.controller.LoginController;

public class HomeActivity extends AppCompatActivity {
private Button btnConsulter;
private EditText etUserName;
private EditText etPassword;
private LoginController LoginController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();

        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName,password;
                Boolean verifUserName = false,verifPassword = false;
                // Check if the username is not empty
                if(!etUserName.getText().toString().isEmpty())
                    verifUserName = true;
                else
                    Toast.makeText(HomeActivity.this, "Veuillez saisir votre nom d'utilisateur", Toast.LENGTH_SHORT).show();
                // Check if the password is not empty
                if(!etPassword.getText().toString().isEmpty())
                    verifPassword = true;
                else
                    Toast.makeText(HomeActivity.this, "Veuillez saisir votre mot de passe", Toast.LENGTH_LONG).show();
                // If both username and password are provided, proceed to the main activity
                if (verifUserName && verifPassword)
                {
                    Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        });

    }
    private void init(){
        LoginController=LoginController.getInstance(HomeActivity.this);
        btnConsulter=(Button)findViewById(R.id.btnConsultation);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etUserName =  (EditText) findViewById(R.id.etUserName);

    }
}