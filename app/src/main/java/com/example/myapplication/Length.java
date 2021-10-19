package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import java.text.DecimalFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import java.math.BigDecimal;
import android.widget.Spinner;
import android.widget.TextView;

import org.apache.commons.lang3.StringUtils;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Length extends Activity {
    private Spinner convertFromSpinner;
    private TextInputEditText convertFromValueInput;
    private TextView resultTextView;
    private Spinner resultSpinner;
    public double convertToMetres(Spinner a, TextInputEditText b) {
        try {
            String input = b.getText().toString().trim();
            if (input.isEmpty()) {
                return 0;
            }
            double d = 0.0;
            switch (a.getSelectedItem().toString()) {
                case "Inches":
                    d = Double.parseDouble(input) / 39.37;
                    break;
                case "Metres":
                    d = Double.parseDouble(input);
                    break;
                case "Centimetres":
                    d = Double.parseDouble(input) / 100;
                    break;
                case "Millimetres":
                    d = Double.parseDouble(input) / 1000;
                    break;
                case "Feet":
                    d = Double.parseDouble(input) / 3.281;
                    break;
                case "Yards":
                    d = Double.parseDouble(input) / 0.9144;
                    break;
                case "Gigametres":
                    d = Double.parseDouble(input) * 1000000000;
                    break;
                case "Megametres":
                    d = Double.parseDouble(input) * 1000000;
                    break;
                case "Kilometres":
                    d = Double.parseDouble(input) * 1000;
                    break;
                case "Decimetres":
                    d = Double.parseDouble(input) * 10;
                    break;
                case "Micrometres":
                    d = Double.parseDouble(input) / 1000000;
                    break;
                case "Nanometres":
                    d = Double.parseDouble(input) / 1000000000;
                    break;
                case "Miles":
                    d = Double.parseDouble(input) * 1609;
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
    public double convertFromMetres(Spinner a, double b) {
        double d = 0.0;
        switch (a.getSelectedItem().toString()) {

            case "Inches":
                d = b * 39.37;
                break;
            case "Metres":
                d = b;
                break;
            case "Centimetres":
                d = b * 100;
                break;
            case "Millimetres":
                d = b * 1000;
                break;
            case "Feet":
                d = b * 3.281;
                break;
            case "Yards":
                d = b * 1.094;
                break;
            case "Gigametres":
                d = b / 1000000000;
                break;
            case "Megametres":
                d = b / 1000000;
                break;
            case "Kilometres":
                d = b / 1000;
                break;
            case "Decimetres":
                d = b * 10;
                break;
            case "Micrometres":
                d = b * 1000000;
                break;
            case "Nanometres":
                d = b * 1000000000;
                break;
            case "Miles":
                d = b / 1609;
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
        setContentView(R.layout.activity_length);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.convertFromLengthArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.convertFromLengthArray, android.R.layout.simple_spinner_item);
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
                resultTextView.setText(Double.toString(convertFromMetres(resultSpinner, convertToMetres(convertFromSpinner, convertFromValueInput))));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                double number = convertFromMetres(resultSpinner, convertToMetres(convertFromSpinner, convertFromValueInput));
                number = Math.round(number * 100.0);
                number = number/100.0;
                resultTextView.setText(Double.toString(convertFromMetres(resultSpinner, convertToMetres(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(Double.toString(convertFromMetres(resultSpinner, convertToMetres(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
