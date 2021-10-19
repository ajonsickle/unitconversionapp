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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unitconversion);
        lengthButton = findViewById(R.id.lengthButton);
        areaButton = findViewById(R.id.areaButton);
        birthdayButton = findViewById(R.id.birthdayButton);

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
                Intent intent = new Intent(UnitConversion.this, Birthday.class);
                startActivity(intent);
            }
        });

    }

}
