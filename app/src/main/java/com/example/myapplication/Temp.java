package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import java.io.Serializable;
import java.text.DecimalFormat;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import java.math.BigDecimal;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.regex.*;

import androidx.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;



public class Temp extends Activity{
    public double convertToCelsius(Spinner a, TextInputEditText b) {
        try {
            String input = b.getText().toString().trim();
            if (input.isEmpty()) {
                return 0;
            }
            double d = 0.0;
            double c = (double)5/9;
            DecimalFormat decimal = new DecimalFormat("#.##");
            switch (a.getSelectedItem().toString()) {
                case "Fahrenheit":
                    d = Double.parseDouble(decimal.format((Double.parseDouble(input) - 32) * (c)));
                    break;
                case "Kelvin":
                    d = Double.parseDouble(decimal.format(Double.parseDouble(input) - 273.15));
                    break;
                case "Celsius":
                    d = Double.parseDouble(input);
                    break;
                default:
                    d = 0;
                    break;
            }
            return d;
        } catch (Exception err) {
            return 0;
        }
    }
    public double convertFromCelsius(Spinner a, double b) {
        double d = 0.0;
        double c = (double)9/5;
        DecimalFormat decimal = new DecimalFormat("#.##");
        switch (a.getSelectedItem().toString()) {
            case "Fahrenheit":
                d = Double.parseDouble(decimal.format((b * (c)) + 32));
                break;
            case "Kelvin":
                d = Double.parseDouble(decimal.format(b + 273.15));
                break;
            case "Celsius":
                d = b;
                break;
            default:
                d = 0;
                break;
        }
        return d;
    }

    private Spinner convertFromSpinner;
    private TextInputEditText convertFromValueInput;
    private TextView resultTextView;
    private Spinner resultSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_generic);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.tempArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.tempArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        convertFromSpinner = (Spinner)findViewById(R.id.convertFromSpinner);
        convertFromSpinner.setAdapter(adapter);
        resultSpinner = (Spinner)findViewById(R.id.resultSpinner);
        resultSpinner.setAdapter(adapter1);
        resultTextView = findViewById(R.id.resultTextView);
        convertFromValueInput = findViewById(R.id.enterConvertFromValueEditText);

        convertFromValueInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                resultTextView.setText(Double.toString(convertFromCelsius(resultSpinner, convertToCelsius(convertFromSpinner, convertFromValueInput))));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(Double.toString(convertFromCelsius(resultSpinner, convertToCelsius(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(Double.toString(convertFromCelsius(resultSpinner, convertToCelsius(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
