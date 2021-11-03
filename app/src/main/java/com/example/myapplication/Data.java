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

public class Data extends Activity {
    private Spinner convertFromSpinner;
    private TextInputEditText convertFromValueInput;
    private TextView resultTextView;
    private Spinner resultSpinner;
    public double convertToBytes(Spinner a, TextInputEditText b) {
        try {
            String input = b.getText().toString().trim();
            if (input.isEmpty()) {
                return 0;
            }
            double d = 0.0;
            switch (a.getSelectedItem().toString()) {
                case "Bits":
                    d = Double.parseDouble(input) / 8;
                    break;
                case "Nibbles":
                    d = Double.parseDouble(input) / 2;
                    break;
                case "Bytes":
                    d = Double.parseDouble(input);
                    break;
                case "Kilobytes":
                    d = Double.parseDouble(input) * 1000;
                    break;
                case "Kibibytes":
                    d = Double.parseDouble(input) * 1024;
                    break;
                case "Megabytes":
                    d = Double.parseDouble(input) * 1000000;
                    break;
                case "Mebibytes":
                    d = Double.parseDouble(input) * 1048576;
                    break;
                case "Gigabytes":
                    d = Double.parseDouble(input) * (1e+9);
                    break;
                case "Gibibytes":
                    d = Double.parseDouble(input) * 1073741824;
                    break;
                case "Terabytes":
                    d = Double.parseDouble(input) * (1e+12);
                    break;
                case "Tebibytes":
                    d = Double.parseDouble(input) * (Math.pow(2, 40));
                    break;
                case "Petabytes":
                    d = Double.parseDouble(input) * (1e+15);
                    break;
                case "Pebibytes":
                    d = Double.parseDouble(input) * (Math.pow(2, 50));
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
    public double convertFromBytes(Spinner a, double b) {
        double d = 0.0;
        switch (a.getSelectedItem().toString()) {
            case "Bits":
                d = b * 8;
                break;
            case "Nibbles":
                d = b * 2;
                break;
            case "Bytes":
                d = b;
                break;
            case "Kilobytes":
                d = b / 1000;
                break;
            case "Kibibytes":
                d = b / 1024;
                break;
            case "Megabytes":
                d = b / 1000000;
                break;
            case "Mebibytes":
                d = b / 1048576;
                break;
            case "Gigabytes":
                d = b / (1e+9);
                break;
            case "Gibibytes":
                d = b / 1073741824;
                break;
            case "Terabytes":
                d = b / (1e+12);
                break;
            case "Tebibytes":
                d = b / (Math.pow(2, 40));
                break;
            case "Petabytes":
                d = b / (1e+15);
                break;
            case "Pebibytes":
                d = b / (Math.pow(2, 50));
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
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.dataArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.dataArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        convertFromSpinner = (Spinner)findViewById(R.id.convertFromSpinner);
        convertFromSpinner.setAdapter(adapter);
        resultSpinner = (Spinner)findViewById(R.id.resultSpinner);
        resultSpinner.setAdapter(adapter1);
        resultTextView = findViewById(R.id.resultTextView);
        convertFromValueInput = findViewById(R.id.enterConvertFromValueEditText);
        DecimalFormat format = new DecimalFormat("#.#######################");
        convertFromValueInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                resultTextView.setText(format.format(convertFromBytes(resultSpinner, convertToBytes(convertFromSpinner, convertFromValueInput))));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(format.format(convertFromBytes(resultSpinner, convertToBytes(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(format.format(convertFromBytes(resultSpinner, convertToBytes(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
