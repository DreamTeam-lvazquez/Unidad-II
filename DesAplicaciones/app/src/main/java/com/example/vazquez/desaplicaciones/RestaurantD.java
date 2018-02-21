package com.example.vazquez.desaplicaciones;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantD extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Restaurant[] restaurants = {
            new Restaurant(R.drawable.rayo, "Casa Pozo del Sol", "Dolores Hidalgo", "418107459"),
            new Restaurant(R.drawable.relicario, "El Relicario","Zona Centro", "418745692"),
            new Restaurant(R.drawable.anber, "Anber","Zona Centro", "4181021894"),
            new Restaurant(R.drawable.insurgente, "Insurgentes","Zona Centro", "418745692"),
            new Restaurant(R.drawable.hidalgp, "Hidalgo","Zona Centro", "4181021894"),
    };

    private ListView lsvRestaurants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);
        lsvRestaurants=findViewById(R.id.lsv_restaurants);
        RestaurantAdapter adapter = new RestaurantAdapter( this,restaurants);
        lsvRestaurants.setAdapter(adapter);
        lsvRestaurants.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String selectedOption=((Restaurant)adapterView.getItemAtPosition(i)).getName();
        Toast.makeText(this, "Seleccionaste: " +selectedOption, Toast.LENGTH_SHORT).show();

    }

    static  class ViewHolder{
        TextView txvName;
        TextView txtLocation;
        TextView txvType;
        ImageView imvPhoto;
    }


    class RestaurantAdapter extends ArrayAdapter<Restaurant> {
        public RestaurantAdapter(@NonNull Context context, Restaurant[] data){
            super (context, R.layout.activity_restaurant_d,data);
        }

        @NonNull
        @Override

        public View getView(int position, @NonNull  View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if(cell == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell= inflater.inflate(R.layout.activity_restaurant_d, null);

                holder = new ViewHolder();
                holder.imvPhoto= cell.findViewById(R.id.imv_photo);
                holder.txvName = cell.findViewById(R.id.txv_name);
                holder.txtLocation =cell.findViewById(R.id.txv_location);
                holder.txvType=cell.findViewById(R.id.txv_type);

                cell.setTag(holder);

            }else{
                holder=(ViewHolder) cell.getTag();
            }

            holder.imvPhoto.setImageResource(restaurants[position].getImageId());
            holder.txvName.setText(restaurants[position].getName());
            holder.txtLocation.setText(restaurants[position].getLocation());
            holder.txvType.setText(restaurants[position].getType());
            return cell;
        }


    }
    public void nextActivityForm(View view) {
        startActivity(new Intent(this,
                Form.class));
    }


}
