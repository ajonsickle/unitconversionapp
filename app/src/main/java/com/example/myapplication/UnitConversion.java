package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UnitConversion extends Activity {

    private Button lengthButton;
    private Button areaButton;
    private Button birthdayButton;
    private Button bmiButton;
    private Button baseButton;
    private Button tempButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unitconversion);
        lengthButton = findViewById(R.id.lengthButton);
        areaButton = findViewById(R.id.areaButton);
        birthdayButton = findViewById(R.id.datesButton);
        bmiButton = findViewById(R.id.bmiButton);
        baseButton = findViewById(R.id.baseNButton);
        tempButton = findViewById(R.id.tempButton);

        lengthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitConversion.this, Length.class);
                startActivity(intent);
            }
        });
        areaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitConversion.this, Area.class);
                startActivity(intent);
            }
        });
        birthdayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitConversion.this, Dates.class);
                startActivity(intent);
            }
        });
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitConversion.this, BMI.class);
                startActivity(intent);
            }
        });
        baseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitConversion.this, Base.class);
                startActivity(intent);
            }
        });
        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitConversion.this, Temp.class);
                startActivity(intent);
            }
        });

    }

}
