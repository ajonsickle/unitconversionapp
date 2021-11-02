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

public class Speed extends Activity{

    private Spinner convertFromSpinner;
    private TextInputEditText convertFromValueInput;
    private TextView resultTextView;
    private Spinner resultSpinner;
    public double convertToMetresPerSecond(Spinner a, TextInputEditText b) {
        try {
            String input = b.getText().toString().trim();
            if (input.isEmpty()) {
                return 0;
            }
            double d = 0.0;
            switch (a.getSelectedItem().toString()) {
                case "m/s":
                    d = Double.parseDouble(input);
                    break;
                case "km/h":
                    d = Double.parseDouble(input) / 3.6;
                    break;
                case "mph":
                    d = Double.parseDouble(input) / 2.237;
                    break;
                case "Knots":
                    d = Double.parseDouble(input) / 1.944;
                    break;
                case "fps":
                    d = Double.parseDouble(input) / 3.281;
                    break;
                case "Mach number":
                    d = Double.parseDouble(input) * 340.29;
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
    public double convertFromMetresPerSecond(Spinner a, double b) {
        double d = 0.0;
        switch (a.getSelectedItem().toString()) {
            case "m/s":
                d = b;
                break;
            case "km/h":
                d = b * 3.6;
                break;
            case "mph":
                d = b * 2.237;
                break;
            case "Knots":
                d = b * 1.944;
                break;
            case "fps":
                d = b * 3.281;
                break;
            case "Mach number":
                d = b / 340.29;
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
        setContentView(R.layout.activity_speed);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.speedArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.speedArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        convertFromSpinner = (Spinner) findViewById(R.id.convertFromSpinner);
        convertFromSpinner.setAdapter(adapter);
        resultSpinner = (Spinner) findViewById(R.id.resultSpinner);
        resultSpinner.setAdapter(adapter1);
        resultTextView = findViewById(R.id.resultTextView);
        convertFromValueInput = findViewById(R.id.enterConvertFromValueEditText);
        DecimalFormat format = new DecimalFormat("#.####");
        convertFromValueInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                resultTextView.setText(format.format(convertFromMetresPerSecond(resultSpinner, convertToMetresPerSecond(convertFromSpinner, convertFromValueInput))));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(format.format(convertFromMetresPerSecond(resultSpinner, convertToMetresPerSecond(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(format.format(convertFromMetresPerSecond(resultSpinner, convertToMetresPerSecond(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
