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

import androidx.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;



public class Time extends Activity {
    private Spinner convertFromSpinner;
    private TextInputEditText convertFromValueInput;
    private TextView resultTextView;
    private Spinner resultSpinner;

    public double convertToDays(Spinner a, TextInputEditText b) {
        try {
            String input = b.getText().toString().trim();
            if (input.isEmpty()) {
                return 0;
            }
            double d = 0.0;
            switch (a.getSelectedItem().toString()) {
                case "Milliseconds":
                    d = Double.parseDouble(input) / (8.64e+7);
                    break;
                case "Seconds":
                    d = Double.parseDouble(input) / 86400;
                    break;
                case "Minutes":
                    d = Double.parseDouble(input) / 1440;
                    break;
                case "Hours":
                    d = Double.parseDouble(input) / 24;
                    break;
                case "Days":
                    d = Double.parseDouble(input);
                    break;
                case "Weeks":
                    d = Double.parseDouble(input) * 7;
                    break;
                case "Months":
                    d = Double.parseDouble(input) * 30.4167;
                    break;
                case "Years":
                    d = Double.parseDouble(input) * 365;
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
    public double convertFromDays(Spinner a, double b) {
        double d = 0.0;
        switch (a.getSelectedItem().toString()) {
            case "Milliseconds":
                d = b * (8.64e+7);
                break;
            case "Seconds":
                d = b * 86400;
                break;
            case "Minutes":
                d = b * 1440;
                break;
            case "Hours":
                d = b * 24;
                break;
            case "Days":
                d = b;
                break;
            case "Weeks":
                d = b / 7;
                break;
            case "Months":
                d = b / 30.4167;
                break;
            case "Years":
                d = b / 365;
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
        setContentView(R.layout.activity_generic);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.timeArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.timeArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        convertFromSpinner = (Spinner)findViewById(R.id.convertFromSpinner);
        convertFromSpinner.setAdapter(adapter);
        resultSpinner = (Spinner)findViewById(R.id.resultSpinner);
        resultSpinner.setAdapter(adapter1);
        resultTextView = findViewById(R.id.resultTextView);
        convertFromValueInput = findViewById(R.id.enterConvertFromValueEditText);

        DecimalFormat twoDP = new DecimalFormat("#.##");

        convertFromValueInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                resultTextView.setText(twoDP.format(convertFromDays(resultSpinner, convertToDays(convertFromSpinner, convertFromValueInput))));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(twoDP.format(convertFromDays(resultSpinner, convertToDays(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(twoDP.format(convertFromDays(resultSpinner, convertToDays(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
