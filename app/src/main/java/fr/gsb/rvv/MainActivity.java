package fr.gsb.rvv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import fr.gsb.rvv.entites.*;
import fr.gsb.rvv.techniques.Session;


public class MainActivity extends AppCompatActivity {

    EditText etMatricule;
    EditText etMdp;
    TextView tvErreur;

    Button leBouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Info","Créeation de l'activité principale");

        etMatricule=(EditText)findViewById(R.id.etMatricule);
        etMdp=(EditText)findViewById(R.id.etMdp);
        tvErreur=(TextView)findViewById(R.id.tvErreur);



    }





    public void seConnecter(View vue) throws UnsupportedEncodingException {
        /*
       Visiteur leVisiteur=ModeleGsb.getInstance().seConnecter(etMatricule.getText().toString(),etMdp.getText().toString());


        if (leVisiteur != null){

            Toast.makeText(this,"Connexion réussi:"+leVisiteur.getMatricule()+leVisiteur.getMdp(), Toast.LENGTH_LONG).show();
            Log.i("Info","Connexion OK"+leVisiteur.getMatricule()+leVisiteur.getMdp());
            Session.ouvrir(leVisiteur);
        }
        else{
            tvErreur.setText("Echec de la connexion.Recommencez");
            etMatricule.setText("");
            etMdp.setText("");
            Log.i("Info","Connexion Nok");
        }
        */

        Log.i( "GSB-RV" , "Se connecter" ) ;

        String matricule = URLEncoder.encode( etMatricule.getText().toString(),"UTF-8");

        String mdp = URLEncoder.encode(etMdp.getText().toString(),"UTF-8");

        String url = String.format("http://192.168.121.145:5000/visiteurs/%s/%s",matricule,mdp);

        Response.Listener<JSONObject> ecouteurReponse = new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {
                try{
                    Log.i( "GSB-RV" , "Réponse serveur REST" ) ;

                    Log.i( "GSB-RV" , response.getString("vis_nom") + " " +response.getString("vis_prenom")) ;


                    Visiteur unVisiteur = new Visiteur();
                    unVisiteur.setMatricule(response.getString("vis_matricule"));
                    unVisiteur.setNom(response.getString("vis_nom"));
                    unVisiteur.setPrenom(response.getString("vis_prenom"));

                    Log.i("APP-RV", "" + unVisiteur);



                    Session.ouvrir(unVisiteur);



                    Intent intentionEnvoyer=new Intent(MainActivity.this, MenuRvActivity.class);


                    Log.i("APP-RV", "Aller vers le menu" );

                    startActivity(intentionEnvoyer);




                }
                catch(JSONException e){
                    Log.e("APP-RV","ERREUR JSON:"+e.getMessage());
                }
            }
        };

        Response.ErrorListener ecouteurErreur = new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("App-rv","Erreur HTTP:"+error.getMessage());
            }
        };


        JsonObjectRequest requete = new JsonObjectRequest(Request.Method.GET,url,null,ecouteurReponse,ecouteurErreur);

        RequestQueue fileDesRequetes = Volley.newRequestQueue(this) ;

        Log.i( "GSB-RV" , "Soumission de la requête" ) ;

        fileDesRequetes.add( requete) ;




    }

    public void annuler(View vue){

        etMatricule.setText("");
        etMdp.setText("");
        Log.i("Info","Initialiser des champs");

    }



}