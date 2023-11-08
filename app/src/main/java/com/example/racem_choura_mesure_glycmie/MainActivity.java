package com.example.racem_choura_mesure_glycmie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private EditText etValeur;
    private SeekBar Sk;
    private Button Bconsulter;
    private TextView tvage, tvres;
    private RadioButton rbIsFasting, rbIsNOTFasting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //Listener seekbar
        Sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("information", "on progress change" + i);
                tvage.setText("votre age:" + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void init() {
        etValeur = (EditText) findViewById(R.id.edittext);
        Sk = (SeekBar) findViewById(R.id.sbAge);
        Bconsulter = (Button) findViewById(R.id.btnconsulter);
        tvage = (TextView) findViewById(R.id.tvAge);
        tvres = (TextView) findViewById(R.id.btnconsulter);
        rbIsFasting = (RadioButton) findViewById(R.id.rbtoui);
        rbIsNOTFasting = (RadioButton) findViewById(R.id.rbtnon);
    }

    // Méthode de calcul appelée lors du clic sur le bouton Consulter
    public void calculer() {
        int age;
        float valeurmasuree;
        boolean verifage = false;
        boolean verifvaleur = false;
        if (Sk.getProgress() != 0) {
            verifage = true;
        } else {
            Toast.makeText(MainActivity.this, "Veuillez vérifier votre age", Toast.LENGTH_SHORT).show();
        }
        if (!etValeur.getText().toString().isEmpty()) {
            verifvaleur = true;
        } else {
            Toast.makeText(MainActivity.this, "Veuillez vérifier la valeur mesurée", Toast.LENGTH_LONG).show();
        }
        if (verifage && verifvaleur) {
            //Traitement
            age = Sk.getProgress();
            valeurmasuree = Float.valueOf(etValeur.getText().toString());
            boolean isFasting = rbIsFasting.isChecked();
            if (isFasting) {
                if (age >= 13) {
                    if (valeurmasuree < 5)
                        tvres.setText("Niveau de glycémie est bas");
                    else if (valeurmasuree >= 5 && valeurmasuree <= 7.2)
                        tvres.setText("Niveau de glycémie est normale");
                    else
                        tvres.setText("Niveau de glycémie est élevé");
                } else if (age >= 6 && age <= 12) {
                    if (valeurmasuree < 5)
                        tvres.setText("Niveau de glycémie est bas");
                    else if (valeurmasuree >= 5 && valeurmasuree <= 10)
                        tvres.setText("Niveau de glycémie est normale");
                    else
                        tvres.setText("Niveau de glycémie est élevé");
                } else if (age < 6) {
                    if (valeurmasuree < 5.5)
                        tvres.setText("Niveau de glycémie est bas");
                    else if (valeurmasuree >= 55 && valeurmasuree <= 10.0)
                        tvres.setText("Niveau de glycémie est normale");
                    else
                        tvres.setText("Niveau de glycémie est élevé ");
                } else {
                    //false
                    if (valeurmasuree > 10.5)
                        tvres.setText("Niveau de glycémie est élevé ");
                    else
                        tvres.setText("Niveau de glycémie est normale ");
                }
            }

        }
    }
}
