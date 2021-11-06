package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import java.text.DecimalFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class Mass extends Activity {

    private Spinner convertFromSpinner;
    private TextInputEditText convertFromValueInput;
    private TextView resultTextView;
    private Spinner resultSpinner;
    public double convertToGrams(Spinner a, TextInputEditText b) {
        try {
            String input = b.getText().toString().trim();
            if (input.isEmpty()) {
                return 0;
            }
            double d = 0.0;
            switch (a.getSelectedItem().toString()) {
                case "Milligrams":
                    d = Double.parseDouble(input) / 1000;
                    break;
                case "Grams":
                    d = Double.parseDouble(input);
                    break;
                case "Kilograms":
                    d = Double.parseDouble(input) * 1000;
                    break;
                case "Tonnes":
                    d = Double.parseDouble(input) * 1e+6;
                    break;
                case "US Tons":
                    d = Double.parseDouble(input) * 907184.74;
                    break;
                case "UK Tons":
                    d = Double.parseDouble(input) * 1016046.91;
                    break;
                case "Pounds":
                    d = Double.parseDouble(input) * 453.59237;
                    break;
                case "Stone":
                    d = Double.parseDouble(input) * 6350.29;
                    break;
                case "Ounces":
                    d = Double.parseDouble(input) * 28.34952;
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
    public double convertFromGrams(Spinner a, double b) {
        double d = 0.0;
        switch (a.getSelectedItem().toString()) {
            case "Milligrams":
                d = b * 1000;
                break;
            case "Grams":
                d = b;
                break;
            case "Kilograms":
                d = b / 1000;
                break;
            case "Tonnes":
                d = b / 1e+6;
                break;
            case "US Tons":
                d = b / 907184.74;
                break;
            case "UK Tons":
                d = b / 1016046.91;
                break;
            case "Pounds":
                d = b / 453.59237;
                break;
            case "Stone":
                d = b / 6350.29;
                break;
            case "Ounces":
                d = b / 28.34952;
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

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.massArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.massArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        convertFromSpinner = (Spinner)findViewById(R.id.convertFromSpinner);
        convertFromSpinner.setAdapter(adapter);
        resultSpinner = (Spinner)findViewById(R.id.resultSpinner);
        resultSpinner.setAdapter(adapter1);
        resultTextView = findViewById(R.id.resultTextView);
        convertFromValueInput = findViewById(R.id.enterConvertFromValueEditText);
        DecimalFormat format = new DecimalFormat("#.############");
        convertFromValueInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                resultTextView.setText(format.format(convertFromGrams(resultSpinner, convertToGrams(convertFromSpinner, convertFromValueInput))));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(format.format(convertFromGrams(resultSpinner, convertToGrams(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(format.format(convertFromGrams(resultSpinner, convertToGrams(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
