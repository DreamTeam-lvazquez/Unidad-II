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

public class ChurchD extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Church[] churchs = {
            new Church(R.drawable.dolores, "Nuestra Señora de los Dolores", "Centro de Dolores Hidalgo", "La Parroquia de Nuestra Señora de Los Dolores está considerado como uno de los mejores ejemplos del barroco novohíspano del último tercio del siglo XVIII."),
            new Church(R.drawable.asuncion, "Parroquia de la Asunción","Centro de Dolores Hidalgo", "La construcción del Templo de la Asunción de María inició el 12 de mayo de 1875 por disposición del Sr. Cura Don José María Gómez. \n" +
                    "\n" +
                    "Antes de ser nombrada como santa patrona bajo la advocación de la Asunción de María, se la veneraba como la Virgen de la Saleta"),
            new Church(R.drawable.tercera, "Tercera Orden","Centro de Dolores Hidalgo", "Después de la Parroquia de Nuestra Sra. De los Dolores, es el inmueble religioso más antiguo de la ciudad, según se aprecia en una inscripción que aparece en el arco del coro indicando que fue cerrado en 1755."),
            new Church(R.drawable.piedrita, "Soledad de Piedrita","Centro de Dolores Hidalgo", "Desde muy temprano  los danzantes llegaron a rendir culto a la virgen de la soledad de piedrita, venerada en el templo del mismo nombre que se encuentra en la calle Aguascalientes casi esquina con la calle Sinaloa, la algarabía de la fiesta se dejó sentir desde un día antes en el que personas en procesión llegaron a agradecer estos 50 años en los que han podido depositar su fe en esta imagen de la Virgen María, pero no fue todo en lo que va del año el lugar ha recibido eventos culturales de calidad tales como conciertos y obras de teatro, por lo que los ciudadanos han disfrutado de un punto de interacción y de esparcimiento en donde también consagran su fe"),


    };

    private ListView lsvChurchs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_church);
        lsvChurchs=findViewById(R.id.lsv_curchs);
        ChurchAdapter adapter = new ChurchAdapter( this,churchs);
        lsvChurchs.setAdapter(adapter);
        lsvChurchs.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String selectedOption=((Church)adapterView.getItemAtPosition(i)).getName();
        Toast.makeText(this, "Seleccionaste: " +selectedOption, Toast.LENGTH_SHORT).show();

    }

    static  class ViewHolder{
        TextView txvName;
        TextView txtLocation;
        TextView txvType;
        ImageView imvPhoto;
    }


    class ChurchAdapter extends ArrayAdapter<Church> {
        public ChurchAdapter(@NonNull Context context, Church[] data){
            super (context, R.layout.activity_church_d,data);
        }

        @NonNull
        @Override

        public View getView(int position, @NonNull  View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if(cell == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell= inflater.inflate(R.layout.activity_church_d, null);

                holder = new ViewHolder();
                holder.imvPhoto= cell.findViewById(R.id.imv_photo);
                holder.txvName = cell.findViewById(R.id.txv_name);
                holder.txtLocation =cell.findViewById(R.id.txv_location);
                holder.txvType=cell.findViewById(R.id.txv_type);

                cell.setTag(holder);

            }else{
                holder=(ViewHolder) cell.getTag();
            }

            holder.imvPhoto.setImageResource(churchs[position].getImageId());
            holder.txvName.setText(churchs[position].getName());
            holder.txtLocation.setText(churchs[position].getLocation());
            holder.txvType.setText(churchs[position].getType());
            return cell;
        }


    }
    public void nextActivityForm(View view) {
        startActivity(new Intent(this,
                Form.class));
    }


}
