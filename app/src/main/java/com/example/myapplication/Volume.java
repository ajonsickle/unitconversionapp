package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import java.text.DecimalFormat;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;

public class Volume extends Activity{

    private Spinner convertFromSpinner;
    private TextInputEditText convertFromValueInput;
    private TextView resultTextView;
    private Spinner resultSpinner;
    public double convertToCubicMetres(Spinner a, TextInputEditText b) {
        try {
            String input = b.getText().toString().trim();
            if (input.isEmpty()) {
                return 0;
            }
            double d = 0.0;
            switch (a.getSelectedItem().toString()) {
                case "Cubic Metres":
                    d = Double.parseDouble(input);
                    break;
                case "Cubic Miles":
                    d = Double.parseDouble(input) * (4.168e+9);
                    break;
                case "Cubic Yards":
                    d = Double.parseDouble(input) / 1.308;
                    break;
                case "Cubic Kilometres":
                    d = Double.parseDouble(input) * 1e+9;
                    break;
                case "Cubic Centimetres":
                case "Millilitres":
                    d = Double.parseDouble(input) / 1e+6;
                    break;
                case "Cubic Millimetres":
                    d = Double.parseDouble(input) / 1e+9;
                    break;
                case "Cubic Feet":
                    d = Double.parseDouble(input) / 35.315;
                    break;
                case "Cubic Inches":
                    d = Double.parseDouble(input)  / 61024;
                    break;
                case "Acre-feet":
                    d = Double.parseDouble(input) * 1233;
                    break;
                case "Centilitres":
                    d = Double.parseDouble(input) / 100000;
                    break;
                case "Litres":
                    d = Double.parseDouble(input) / 1000;
                    break;
                case "Imperial Gallon":
                    d = Double.parseDouble(input) / 220;
                    break;
                case "US Gallon":
                    d = Double.parseDouble(input) / 264;
                    break;
                case "Imperial Pint":
                    d = Double.parseDouble(input) / 1760;
                    break;
                case "US Pint":
                    d = Double.parseDouble(input) / 2113;
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
    public double convertFromCubicMetres(Spinner a, double b) {
        double d = 0.0;
        switch (a.getSelectedItem().toString()) {
            case "Cubic Metres":
                d = b;
                break;
            case "Cubic Miles":
                d = b / (4.168e+9);
                break;
            case "Cubic Yards":
                d = b * 1.308;
                break;
            case "Cubic Kilometres":
                d = b / 1e+9;
                break;
            case "Cubic Centimetres":
            case "Millilitres":
                d = b * 1e+6;
                break;
            case "Cubic Millimetres":
                d = b * 1e+9;
                break;
            case "Cubic Feet":
                d = b * 35.315;
                break;
            case "Cubic Inches":
                d = b * 61024;
                break;
            case "Acre-feet":
                d = b / 1233;
                break;
            case "Centilitres":
                d = b * 100000;
                break;
            case "Litres":
                d = b * 1000;
                break;
            case "Imperial Gallon":
                d = b * 220;
                break;
            case "US Gallon":
                d = b * 264;
                break;
            case "Imperial Pint":
                d = b * 1760;
                break;
            case "US Pint":
                d = b * 2113;
                break;
            default:
                d = 0;
                break;
        }
        return d;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_generic);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.volumeArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.volumeArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        convertFromSpinner = (Spinner)findViewById(R.id.convertFromSpinner);
        convertFromSpinner.setAdapter(adapter);
        resultSpinner = (Spinner)findViewById(R.id.resultSpinner);
        resultSpinner.setAdapter(adapter1);
        resultTextView = findViewById(R.id.resultTextView);
        convertFromValueInput = findViewById(R.id.enterConvertFromValueEditText);
        DecimalFormat format = new DecimalFormat("#.########");
        convertFromValueInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                resultTextView.setText(format.format(convertFromCubicMetres(resultSpinner, convertToCubicMetres(convertFromSpinner, convertFromValueInput))));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(format.format(convertFromCubicMetres(resultSpinner, convertToCubicMetres(convertFromSpinner, convertFromValueInput))));
            }
            @Override

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(format.format(convertFromCubicMetres(resultSpinner, convertToCubicMetres(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
