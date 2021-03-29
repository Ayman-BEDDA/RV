package fr.gsb.rvv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ListeRvActivity extends AppCompatActivity {

    TextView tvMois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);

        tvMois=(TextView)findViewById(R.id.tvMois);


    }
}