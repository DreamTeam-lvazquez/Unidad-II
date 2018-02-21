package com.example.vazquez.desaplicaciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
    }

    public void nextActivityComp(View view) {
        startActivity(new Intent(this,
                GridActivity.class));
    }

    public void nextActivityVal(View view) {
        startActivity(new Intent(this,
                LinearActivity.class));
    }

    public void nextActivityChurch(View view) {
        startActivity(new Intent(this,
                ChurchD.class));
    }
    public void nextActivityBar(View view) {
        startActivity(new Intent(this,
                BarD.class));
    }
    public void nextActivityRestaurant(View view) {
        startActivity(new Intent(this,
                RestaurantD.class));
    }
    public void nextActivityGalery(View view) {
        startActivity(new Intent(this,
                GaleryD.class));
    }

    public void nextActivityFestivity(View view) {
        startActivity(new Intent(this,
                FestivityD.class));
    }
}
