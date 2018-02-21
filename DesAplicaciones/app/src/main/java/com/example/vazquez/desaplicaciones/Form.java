package com.example.vazquez.desaplicaciones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by vazquez on 17/02/2018.
 */

public class Form extends AppCompatActivity {
    private EditText txtName;
    private EditText txtLocation;
    private EditText txtPhone;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        txtName = (EditText) findViewById(R.id.edt_name);
        txtLocation = (EditText) findViewById(R.id.edt_age);
        txtPhone = (EditText) findViewById(R.id.edt_phone);
        btnSubmit = (Button) findViewById(R.id.btn_sub);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Form.this, DataActivity.class);
                Bundle b = new Bundle();
                b.putString("Name", txtName.getText().toString());
                b.putString("Location", txtLocation.getText().toString());
                b.putString("Phone", txtPhone.getText().toString());
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }

    public void nextActivityData(View view) {
        startActivity(new Intent(this,
                DataActivity.class));
    }
    }