package fr.gsb.rvv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RechercherRvActivity extends AppCompatActivity {

    private static final Integer[] lesMois={1,2,3,4,5,6,7,8,9,10,11,12};
    private static final Integer[] lesAnnee={2015,2016,2017,2018,2019,2020,2021,2022};

    Spinner spMois;
    Spinner spAnnee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rechercher_rv);

        spMois=(Spinner)findViewById(R.id.spMois);
        spAnnee=(Spinner)findViewById(R.id.spAnnee);

        //Mois
        ArrayAdapter<Integer> mois=new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,lesMois);

        mois.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spMois.setAdapter(mois);


        //ANNEE
        ArrayAdapter<Integer> annee=new ArrayAdapter<Integer>(this,android.R.layout.simple_spinner_item,lesAnnee);

        annee.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spAnnee.setAdapter(annee);

    }


    public void envoyer(View vue){
        Bundle paquet=new Bundle();
        paquet.putString("mois",anne);
    }


    public void retourner(View vue){
        Intent intentRetourner=new Intent (RechercherRvActivity.this, MenuRvActivity.class);
        startActivity(intentRetourner);
    }
}
