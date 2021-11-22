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
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputEditText;

public class Frequency1 extends Activity {

    public double convertToWavelength(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Frequency (Hz)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }
    public double convertToVelocity(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        return Double.parseDouble(String.valueOf(b.getText())) * Double.parseDouble(String.valueOf(a.getText()));
    }
    public double convertToFrequency1(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d, String equation) {

        if (c.getSelectedItem().toString().equals("Wavelength λ (m)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }

    }
    public double convertToFrequency2(TextInputEditText a, Spinner c) {

        return 1 / Double.parseDouble(String.valueOf(a.getText()));

    }
    public double convertToTimePeriod(TextInputEditText a, Spinner c) {

        return 1 / Double.parseDouble(String.valueOf(a.getText()));

    }

    String selectedEquation = "F=1/T";
    private Spinner convertFromSpinner;
    private TextInputEditText convertFromValueInput;
    private TextView resultTextView;
    private Spinner resultSpinner;
    private Spinner convertFromSpinner2;
    private TextInputEditText convertFromValueInput2;
    private Spinner equationSpinner;
    DecimalFormat format = new DecimalFormat("#.####");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (selectedEquation.equals("F=1/T")) {
            setContentView(R.layout.activity_frequency1);
            ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.frequencyEquations, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.frequencyArray2, android.R.layout.simple_spinner_item);
            adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.frequencyArray1, android.R.layout.simple_spinner_item);
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            convertFromSpinner = (Spinner) findViewById(R.id.convertFromSpinner);
            convertFromSpinner.setAdapter(adapter);
            resultSpinner = (Spinner) findViewById(R.id.resultSpinner);
            resultSpinner.setAdapter(adapter1);
            resultTextView = findViewById(R.id.resultTextView);
            convertFromValueInput = findViewById(R.id.enterConvertFromValueEditText);
            DecimalFormat format = new DecimalFormat("#.####");
            equationSpinner = (Spinner) findViewById(R.id.equationSpinner);
            equationSpinner.setAdapter(adapter);
            equationSpinner.setSelection(adapter.getPosition("F=1/T"));


            equationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    selectedEquation = equationSpinner.getSelectedItem().toString();
                    if (selectedEquation.equals("F=V/λ")) {
                        Intent intent = new Intent(Frequency1.this, Frequency.class);
                        startActivity(intent);
                    } else {
                        resultSpinner.setAdapter(adapter2);
                        resultSpinner.setSelection(1);
                        convertFromSpinner.setAdapter(adapter2);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            convertFromValueInput.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    mainFunction1(adapter2);

                }

                @Override
                public void afterTextChanged(Editable editable) {

                }
            });
            convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    mainFunction1(adapter2);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    mainFunction1(adapter2);
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }

    }

    public void mainFunction1(ArrayAdapter adapter2) {
        try {
            if (convertFromSpinner.getSelectedItem().toString().equals("Frequency (Hz)")) {
                resultSpinner.setSelection(adapter2.getPosition("Time Period (s)"));
                resultTextView.setText(format.format(convertToTimePeriod(convertFromValueInput, convertFromSpinner)));
            } else {
                resultSpinner.setSelection(adapter2.getPosition("Frequency (Hz)"));
                resultTextView.setText(format.format(convertToFrequency2(convertFromValueInput, convertFromSpinner)));
            }
        } catch (Exception err) {

        }
    }


}
