package com.example.racem_choura_mesure_glycmie.view;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.racem_choura_mesure_glycmie.R;
import com.example.racem_choura_mesure_glycmie.controller.Controller;

public class MainActivity extends AppCompatActivity {
    private  final int REQUEST_CODE=1;
    private EditText etValeur ;
    private Button btnConsulter;
    private SeekBar sbAge;
    private RadioButton rbIsFasting ,rbIsNotFasting;
    private TextView tvAge; //tvres;
    private RadioGroup group;

    private Controller controller = Controller.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //listener seekbar
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                Log.i("INFORMATION","onProgressChanged"+progress);
                tvAge.setText("Votre age="+progress);}


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
        btnConsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int age;
                float valeurMesure;
                boolean verifAge = false;
                boolean verifValeur = false;
                if (sbAge.getProgress() != 0) {
                    verifAge = true;
                } else {
                    //length_show le temps de message
                    Toast.makeText(MainActivity.this, "Veuillez Verifier votre Age", Toast.LENGTH_SHORT).show();
                }
                if (!etValeur.getText().toString().isEmpty()) {
                    verifValeur = true;
                } else {
                    Toast.makeText(MainActivity.this, "Veuillez Verifier le valeur Mesure ", Toast.LENGTH_LONG).show();
                }
                if (verifAge && verifValeur) {
                    age = sbAge.getProgress();
                    valeurMesure = Float.valueOf(etValeur.getText().toString());
                    boolean IsFasting = rbIsFasting.isChecked();
                    //useraction:view to controller
                    controller.create_patient(age, valeurMesure, IsFasting);
                    //update cntroller to view
                    //tvres.setText(controller.getResult());
                    Intent intent = new Intent(MainActivity.this, ConsulteActivity.class);
                    intent.putExtra("reponse",controller.getResult() );
                    startActivityForResult(intent,REQUEST_CODE);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE)
            if(resultCode==RESULT_CANCELED)
                Toast.makeText(MainActivity.this,"Erreur",Toast.LENGTH_SHORT).show();
    }

    public void init()
    {
        etValeur = (EditText) findViewById(R.id.edittext);
        sbAge = (SeekBar) findViewById(R.id.sbAge);
        btnConsulter =(Button) findViewById(R.id.btnconsulter);
        rbIsFasting =(RadioButton) findViewById(R.id.rbtoui);
        rbIsNotFasting =(RadioButton) findViewById(R.id.rbtnon);
        tvAge =(TextView) findViewById(R.id.tvAge);
        //tvres = (TextView) findViewById(R.id.btnconsulter);
        //Intent intent=new Intent(MainActivity.this,ConsulteActivity.class);
       // intent.putExtra("réponse",controller.getResult());

    }


}

