package com.example.vazquez.desaplicaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class RelativeActivity extends AppCompatActivity {

    private TextView txtData;
    private Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);
        txtData = (TextView) findViewById(R.id.txtData);
        Bundle bundle = this.getIntent().getExtras();
        txtData.setText("Hello: " + bundle.getString("Name") + ", " +
                bundle.getString("Age") + ", " + bundle.getString("Phone"));
    }
}
