package com.avances.applima.presentation.ui.activities;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.avances.applima.R;
import com.avances.applima.domain.model.Distrit;
import com.avances.applima.domain.model.Place;
import com.avances.applima.presentation.ui.adapters.DistritHorizontalListDataAdapter;
import com.avances.applima.presentation.ui.adapters.PlacesHorizontalListDataAdapter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {


    ArrayList<Distrit> distrits;
    ArrayList<Place> places;
    RecyclerView rvDistritos, rvLugares, rvMejoresRutas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        loadShitData();
    }

    private void initUI() {
        rvDistritos = (RecyclerView) findViewById(R.id.rv_distritos);
        rvLugares = (RecyclerView) findViewById(R.id.rv_lugares);
        rvMejoresRutas = (RecyclerView) findViewById(R.id.rv_mejoresrutas);
    }

    public void loadShitData() {

        distrits = new ArrayList<Distrit>();
        for (int j = 0; j <= 5; j++) {
            distrits.add(new Distrit("Item " + j, "URL " + j));
        }


        places = new ArrayList<Place>();
        for (int j = 0; j <= 5; j++) {
            places.add(new Place("Item " + j, "URL " + j));
        }


        DistritHorizontalListDataAdapter itemListDataAdapter = new DistritHorizontalListDataAdapter(getApplicationContext(), distrits);

        rvDistritos.setHasFixedSize(true);
        rvDistritos.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        rvDistritos.setAdapter(itemListDataAdapter);


        PlacesHorizontalListDataAdapter routesHorizontalDataAdapter = new PlacesHorizontalListDataAdapter(getApplicationContext(), places);

        rvLugares.setHasFixedSize(true);
        rvLugares.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        rvLugares.setAdapter(routesHorizontalDataAdapter);

        rvMejoresRutas.setHasFixedSize(true);
        rvMejoresRutas.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        rvMejoresRutas.setAdapter(routesHorizontalDataAdapter);

    }
}
