package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class UnitConversion extends Activity {

    private Button lengthButton, areaButton, birthdayButton, bmiButton, baseButton, tempButton, timeButton, dataButton, moneyButton, speedButton, volumeButton, massButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_unitconversion);
        lengthButton = findViewById(R.id.lengthButton);
        areaButton = findViewById(R.id.areaButton);
        birthdayButton = findViewById(R.id.datesButton);
        bmiButton = findViewById(R.id.bmiButton);
        baseButton = findViewById(R.id.baseNButton);
        tempButton = findViewById(R.id.tempButton);
        timeButton = findViewById(R.id.timeButton);
        dataButton = findViewById(R.id.dataButton);
        moneyButton = findViewById(R.id.moneyButton);
        speedButton = findViewById(R.id.speedButton);
        volumeButton = findViewById(R.id.volumeButton);
        massButton = findViewById(R.id.massButton);

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
        timeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitConversion.this, Time.class);
                startActivity(intent);
            }
        });
        dataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitConversion.this, Data.class);
                startActivity(intent);
            }
        });
        moneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitConversion.this, Money.class);
                startActivity(intent);
            }
        });
        speedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitConversion.this, Speed.class);
                startActivity(intent);
            }
        });
        volumeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitConversion.this, Volume.class);
                startActivity(intent);
            }
        });
        massButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UnitConversion.this, Mass.class);
                startActivity(intent);
            }
        });

    }

}
