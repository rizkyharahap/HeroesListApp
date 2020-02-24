package com.haphap.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Hero> listHero = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvHero = findViewById(R.id.rv_list);
        RecyclerView rvHorizontal = findViewById(R.id.rv_horizontal_list);

        listHero.addAll(HeroesData.getListData());

        rvHero.setHasFixedSize(true);
        rvHorizontal.setHasFixedSize(true);

        rvHorizontal.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvHero.setLayoutManager(new LinearLayoutManager(this));

        HeroAdapter heroAdapterHorizontal = new HeroAdapter(listHero, getApplicationContext(), 1);
        HeroAdapter heroAdapter = new HeroAdapter(listHero, getApplicationContext(), 2);

        rvHorizontal.setAdapter(heroAdapterHorizontal);
        rvHero.setAdapter(heroAdapter);



    }
}
