package com.example.vazquez.desaplicaciones;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class DataActivity extends AppCompatActivity {
    private TextView txtData;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        txtData = (TextView) findViewById(R.id.txtData);
        Bundle bundle = this.getIntent().getExtras();
        txtData.setText( bundle.getString("Name") + ", " +
                bundle.getString("Location") + ", " + bundle.getString("Phone"));
    }
}
