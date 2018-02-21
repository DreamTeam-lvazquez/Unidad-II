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

public class BarD extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Bar[] bars = {
            new Bar(R.drawable.mil, "Bar el mil Amores", "Calzada de los Heroes #43, Ciudad de Dolores Hidalgo", "01 418 184 4474"),
            new Bar(R.drawable.josefa, "La Josefa","Guanajuato 5, Ciudad de Dolores Hidalgo",
                    "01 418 182 0033"),
            new Bar(R.drawable.barblue, "Bar Blue","Calzada de los heroes,Ciudad de Dolores Hidalgo",
                    "01 418 117 5233"),
            new Bar(R.drawable.mama, "Mamá Dolores"," Plaza Principal,Ciudad de Dolores Hidalgo", "01 418 182 1778"),
            new Bar(R.drawable.tercer, "3 Pisso","Calzada de los Héroes 112,Ciudad de Dolores Hidalgo", "01 418 101 1865"),


    };

    private ListView lsvBars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        lsvBars=findViewById(R.id.lsv_bars);
        BarAdapter adapter = new BarAdapter( this,bars);
        lsvBars.setAdapter(adapter);
        lsvBars.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String selectedOption=((Bar)adapterView.getItemAtPosition(i)).getName();
        Toast.makeText(this, "You selected: " +selectedOption, Toast.LENGTH_SHORT).show();

    }

    static  class ViewHolder{
        TextView txvName;
        TextView txtLocation;
        TextView txvType;
        ImageView imvPhoto;
    }


    class BarAdapter extends ArrayAdapter<Bar> {
        public BarAdapter(@NonNull Context context, Bar[] data){
            super (context, R.layout.activity_bar_d,data);
        }

        @NonNull
        @Override

        public View getView(int position, @NonNull  View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if(cell == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell= inflater.inflate(R.layout.activity_bar_d, null);

                holder = new ViewHolder();
                holder.imvPhoto= cell.findViewById(R.id.imv_photo);
                holder.txvName = cell.findViewById(R.id.txv_name);
                holder.txtLocation =cell.findViewById(R.id.txv_location);
                holder.txvType=cell.findViewById(R.id.txv_type);

                cell.setTag(holder);

            }else{
                holder=(ViewHolder) cell.getTag();
            }

            holder.imvPhoto.setImageResource(bars[position].getImageId());
            holder.txvName.setText(bars[position].getName());
            holder.txtLocation.setText(bars[position].getLocation());
            holder.txvType.setText(bars[position].getType());
            return cell;
        }


    }
    public void nextActivityForm(View view) {
        startActivity(new Intent(this,
                Form.class));
    }


}
