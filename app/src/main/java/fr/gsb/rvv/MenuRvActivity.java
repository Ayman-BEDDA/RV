package fr.gsb.rvv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fr.gsb.rvv.techniques.Session;

import fr.gsb.rvv.entites.Visiteur;

public class MenuRvActivity extends AppCompatActivity {

    TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menurv);

        tvMessage = (TextView) findViewById( R.id.tvMessage  );
        tvMessage.setText( Session.getSession().getLeVisiteur().getNom() );
    }

    public void envoyerRechercher(View vue){

        Intent intentionEnvoyer=new Intent(MenuRvActivity.this, RechercherRvActivity.class);

        startActivity(intentionEnvoyer);


    }


    public void retourner(View vue){
        Intent intentRetourner=new Intent (MenuRvActivity.this, MainActivity.class);
        startActivity(intentRetourner);
    }
}