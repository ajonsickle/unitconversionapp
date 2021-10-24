package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import java.io.Serializable;
import java.text.DecimalFormat;
import android.view.View;
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


public class Base extends Activity {
    private Spinner convertFromSpinner;
    private TextInputEditText convertFromValueInput;
    private TextView resultTextView;
    private Spinner resultSpinner;

    public long convertToDecimal(Spinner convertFromSpinner, TextInputEditText convertFromValueInput) {
        try {
            if (convertFromSpinner.getSelectedItem().equals("Binary")) {
                return Integer.parseInt(String.valueOf(convertFromValueInput.getText()), 2);
            } else if (convertFromSpinner.getSelectedItem().equals("Hex")) {
                return Integer.parseInt(String.valueOf(convertFromValueInput.getText()), 16);
            } else if (convertFromSpinner.getSelectedItem().equals("Octal")) {
                return Integer.parseInt(String.valueOf(convertFromValueInput.getText()), 8);
            } else if (convertFromSpinner.getSelectedItem().equals("Decimal")) {
                return Long.parseLong(String.valueOf(convertFromValueInput.getText()));
            } else {
                return 0;
            }
        } catch (Exception err) {
            return 0;
        }
    }
    public Serializable convertFromDecimal(Spinner resultSpinner, long b) {
        try {
            if (resultSpinner.getSelectedItem().equals("Binary")) {
                return Long.toBinaryString(b);
            } else if (resultSpinner.getSelectedItem().equals("Hex")) {
                return Long.toHexString(b);
            } else if (resultSpinner.getSelectedItem().equals("Octal")) {
                return Long.toOctalString(b);
            } else if (resultSpinner.getSelectedItem().equals("Decimal")) {
                return b;
            } else {
                return 0;
            }
        } catch (Exception err) {
            return "Invalid Input!";
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.baseArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.baseArray, android.R.layout.simple_spinner_item);
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

                        resultTextView.setText(convertFromDecimal(resultSpinner, convertToDecimal(convertFromSpinner, convertFromValueInput)).toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(convertFromDecimal(resultSpinner, convertToDecimal(convertFromSpinner, convertFromValueInput)).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(convertFromDecimal(resultSpinner, convertToDecimal(convertFromSpinner, convertFromValueInput)).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
