package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Equations extends Activity {

    private Button speedButton, forceButton, pressureButton, powerButton, accelerationButton, densityButton, voltageButton, frequencyButton, keButton, weightButton, momentumButton, chargeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_equations);

        speedButton = findViewById(R.id.speedButton);
        forceButton = findViewById(R.id.forceButton);
        pressureButton = findViewById(R.id.pressureButton);
        powerButton = findViewById(R.id.powerButton);
        accelerationButton = findViewById(R.id.accelerationButton);
        densityButton = findViewById(R.id.densityButton);
        voltageButton = findViewById(R.id.voltageButton);
        frequencyButton = findViewById(R.id.frequencyButton);
        keButton = findViewById(R.id.keButton);
        weightButton = findViewById(R.id.weightButton);
        momentumButton = findViewById(R.id.momentumButton);
        chargeButton = findViewById(R.id.chargeButton);

        speedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Equations.this, Velocity.class);
                startActivity(intent);
            }
        });
        forceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Equations.this, Force.class);
                startActivity(intent);
            }
        });
        pressureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Equations.this, Pressure.class);
                startActivity(intent);
            }
        });
        powerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Equations.this, Power.class);
                startActivity(intent);
            }
        });
        accelerationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Equations.this, Acceleration.class);
                startActivity(intent);
            }
        });
        densityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Equations.this, Density.class);
                startActivity(intent);
            }
        });
        voltageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Equations.this, Voltage.class);
                startActivity(intent);
            }
        });
        frequencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Equations.this, Frequency.class);
                startActivity(intent);
            }
        });
        keButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Equations.this, KE.class);
                startActivity(intent);
            }
        });
        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Equations.this, Weight.class);
                startActivity(intent);
            }
        });
        momentumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Equations.this, Momentum.class);
                startActivity(intent);
            }
        });
        chargeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Equations.this, Charge.class);
                startActivity(intent);
            }
        });




    }
}
