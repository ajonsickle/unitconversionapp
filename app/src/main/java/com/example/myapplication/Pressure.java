package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import java.text.DecimalFormat;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import java.math.BigDecimal;
import android.widget.Spinner;
import android.widget.TextView;


import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Text;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Pressure extends Activity{

    public double convertToPressure(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Area (m^2)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }

    public double convertToForce(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {

        return Double.parseDouble(String.valueOf(a.getText())) * Double.parseDouble(String.valueOf(b.getText()));
    }

    public double convertToArea(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Pressure (Pa)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }

    private Spinner convertFromSpinner;
    private TextInputEditText convertFromValueInput;
    private TextView resultTextView;
    private Spinner resultSpinner;
    private Spinner convertFromSpinner2;
    private TextInputEditText convertFromValueInput2;
    DecimalFormat format = new DecimalFormat("#.####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_generic_equations);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.pressureArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.pressureArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        convertFromSpinner = (Spinner) findViewById(R.id.convertFromSpinner);
        convertFromSpinner.setAdapter(adapter);
        resultSpinner = (Spinner) findViewById(R.id.resultSpinner);
        resultSpinner.setAdapter(adapter1);
        resultTextView = findViewById(R.id.resultTextView);
        convertFromValueInput = findViewById(R.id.enterConvertFromValueEditText);
        convertFromSpinner2 = (Spinner) findViewById(R.id.convertFromSpinner2);
        convertFromSpinner2.setAdapter(adapter);
        convertFromSpinner2.setSelection(1);
        convertFromValueInput2 = findViewById(R.id.enterConvertFromValueEditText2);

        convertFromValueInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mainFunction(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromValueInput2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                mainFunction(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainFunction(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        convertFromSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainFunction(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainFunction(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void mainFunction(ArrayAdapter adapter) {
        try {
            if ((convertFromSpinner.getSelectedItem().toString().equals("Pressure (Pa)") || convertFromSpinner.getSelectedItem().toString().equals("Force (N)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Pressure (Pa)") || convertFromSpinner2.getSelectedItem().toString().equals("Force (N)"))) {
                resultSpinner.setSelection(adapter.getPosition("Area (m^2)"));
                resultTextView.setText(format.format(convertToArea(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
            } else if ((convertFromSpinner.getSelectedItem().toString().equals("Force (N)") || convertFromSpinner.getSelectedItem().toString().equals("Area (m^2)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Force (N)") || convertFromSpinner2.getSelectedItem().toString().equals("Area (m^2)"))) {
                resultSpinner.setSelection(adapter.getPosition("Pressure (Pa)"));
                resultTextView.setText(format.format(convertToPressure(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
            } else if ((convertFromSpinner.getSelectedItem().toString().equals("Pressure (Pa)") || convertFromSpinner.getSelectedItem().toString().equals("Area (m^2)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Pressure (Pa)") || convertFromSpinner2.getSelectedItem().toString().equals("Area (m^2)"))) {
                resultSpinner.setSelection(adapter.getPosition("Force (N)"));
                resultTextView.setText(format.format(convertToForce(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
            }
        } catch (Exception err) {

        }
    }
}
