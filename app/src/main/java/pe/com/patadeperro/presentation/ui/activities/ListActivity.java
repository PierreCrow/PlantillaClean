package pe.com.patadeperro.presentation.ui.activities;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.com.patadeperro.R;
import pe.com.patadeperro.domain.model.Place;
import pe.com.patadeperro.presentation.ui.adapters.VerticalListDataAdapter;

import java.util.ArrayList;

import static com.mapbox.mapboxsdk.style.expressions.Expression.eq;
import static com.mapbox.mapboxsdk.style.expressions.Expression.get;
import static com.mapbox.mapboxsdk.style.expressions.Expression.literal;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAllowOverlap;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconAnchor;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconImage;
import static com.mapbox.mapboxsdk.style.layers.PropertyFactory.iconOffset;

public class ListActivity extends BaseActivity implements VerticalListDataAdapter.OnItemClickListener {



    private VerticalListDataAdapter.OnItemClickListener mlistener;
    RecyclerView rvLugares;
    ArrayList<Place> places;
    ImageView ivGoToMap, ivBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lista_activity);


        initUI();

        clickEvents();

        addListaHoriozontal();

    }


    private void initUI() {

        mlistener = this;
        rvLugares = (RecyclerView) findViewById(R.id.rv_lugaress);
        ivGoToMap = (ImageView) findViewById(R.id.ivGoToMap);
        ivBack = (ImageView) findViewById(R.id.ivBack);

    }


    void clickEvents() {

        ivGoToMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                next(MapActivity.class);

            }
        });


        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                next(MainActivity.class);

            }
        });

    }


    void addListaHoriozontal() {
        places = new ArrayList<Place>();
        for (int j = 0; j <= 5; j++) {
            places.add(new Place("La noche de barranco" + j, "URL " + j));
        }

        int[] ATTRS = new int[]{android.R.attr.listDivider};

        TypedArray a = getApplicationContext().obtainStyledAttributes(ATTRS);
        Drawable divider = a.getDrawable(0);
        int inset = getResources().getDimensionPixelSize(R.dimen.list_vertical_margin);
        InsetDrawable insetDivider = new InsetDrawable(divider, inset, 0, inset, 0);
        a.recycle();

        DividerItemDecoration itemDecoration = new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(insetDivider);
        rvLugares.addItemDecoration(itemDecoration);

        VerticalListDataAdapter routesHorizontalDataAdapter = new VerticalListDataAdapter(mlistener, getApplicationContext(), places);

        rvLugares.setHasFixedSize(true);
        rvLugares.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        rvLugares.setAdapter(routesHorizontalDataAdapter);
    }


    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();

    }


    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }


    @Override
    public void onItemClicked(View v, Place category) {

    }
}
