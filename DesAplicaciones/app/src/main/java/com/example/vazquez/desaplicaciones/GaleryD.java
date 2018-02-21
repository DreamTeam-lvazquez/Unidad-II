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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GaleryD extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Galery[] galeries = {
            new Galery(R.drawable.uno,"Iglesia de los Dolores"),
            new Galery(R.drawable.tres, "Monumento a Hidalgo"),
            new Galery(R.drawable.reloj, "Callejón Casiano Exiga"),
            new Galery(R.drawable.mural, "Callejón Casiano Exiga"),


    };
    private GridView lsvGaleries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galery2);
        lsvGaleries=findViewById(R.id.lsv_galery);
        GaleryAdapter adapter = new GaleryAdapter( this,galeries);
        lsvGaleries.setAdapter(adapter);
        lsvGaleries.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String selectedOption=((Galery)adapterView.getItemAtPosition(i)).getName();
        Toast.makeText(this, "Seleccionaste: " +selectedOption, Toast.LENGTH_SHORT).show();

    }

    static  class ViewHolder{
        TextView txvName;
        ImageView imvPhoto;
    }


    class GaleryAdapter extends ArrayAdapter<Galery> {
        public GaleryAdapter(@NonNull Context context, Galery[] data){
            super (context, R.layout.activity_gallery,data);
        }

        @NonNull
        @Override

        public View getView(int position, @NonNull  View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if(cell == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell= inflater.inflate(R.layout.activity_gallery, null);

                holder = new GaleryD.ViewHolder();
                holder.imvPhoto= cell.findViewById(R.id.imv_photo);
                holder.txvName = cell.findViewById(R.id.imv_name);

                cell.setTag(holder);

            }else{
                holder=(ViewHolder) cell.getTag();
            }

            holder.imvPhoto.setImageResource(galeries[position].getImageId());
            holder.txvName.setText(galeries[position].getName());

            return cell;
        }


    }




}
