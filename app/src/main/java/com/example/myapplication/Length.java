package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Length extends Activity {
    private Spinner convertFromSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.convertFromArray, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        convertFromSpinner = (Spinner)findViewById(R.id.convertFromSpinner);
        convertFromSpinner.setAdapter(adapter);
    }
}
