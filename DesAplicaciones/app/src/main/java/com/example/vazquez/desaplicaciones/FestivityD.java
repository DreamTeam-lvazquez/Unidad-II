package com.example.vazquez.desaplicaciones;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FestivityD extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Festivity[] festivities = {
            new Festivity(R.drawable.dolores, "Día de Virgen de los Dolores", "23 de Marzo", ""),
            new Festivity(R.drawable.tercera, "Día de las nieves","2 y 3 de Julio", ""),
            new Festivity(R.drawable.asuncion, "Fiestas Patrias","15 de Septiembre", ""),
            new Festivity(R.drawable.piedrita, "Día de Muertos","2 de Noviembre", ""),


    };

    private ListView lsvFestivities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festivity);
        lsvFestivities=findViewById(R.id.lsv_festivities);
        FestivityAdapter adapter = new FestivityAdapter( this,festivities);
        lsvFestivities.setAdapter(adapter);
        lsvFestivities.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String selectedOption=((Festivity)adapterView.getItemAtPosition(i)).getName();
        Toast.makeText(this, "Seleccionaste: " +selectedOption, Toast.LENGTH_SHORT).show();

    }

    static  class ViewHolder{
        TextView txvName;
        TextView txtLocation;
        TextView txvType;
        ImageView imvPhoto;
    }


    class FestivityAdapter extends ArrayAdapter<Festivity> {
        public FestivityAdapter(@NonNull Context context, Festivity[] data){
            super (context, R.layout.activity_festivity_d,data);
        }

        @NonNull
        @Override

        public View getView(int position, @NonNull  View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if(cell == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell= inflater.inflate(R.layout.activity_festivity_d, null);

                holder = new ViewHolder();
                holder.imvPhoto= cell.findViewById(R.id.imv_photo);
                holder.txvName = cell.findViewById(R.id.txv_name);
                holder.txtLocation =cell.findViewById(R.id.txv_location);
                holder.txvType=cell.findViewById(R.id.txv_type);

                cell.setTag(holder);

            }else{
                holder=(ViewHolder) cell.getTag();
            }

            holder.imvPhoto.setImageResource(festivities[position].getImageId());
            holder.txvName.setText(festivities[position].getName());
            holder.txtLocation.setText(festivities[position].getLocation());
            holder.txvType.setText(festivities[position].getType());
            return cell;
        }


    }

    public void nextActivityForm(View view) {
        startActivity(new Intent(this,
                Form.class));
    }

}
