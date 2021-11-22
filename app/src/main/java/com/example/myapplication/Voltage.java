package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputEditText;

public class Voltage extends Activity {

    public double convertToCurrent(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d, String equation) {
        if (equation.equals("V=IR")) {
            if (c.getSelectedItem().toString().equals("Resistance (Ω)")) {
                return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
            } else {
                return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
            }
        } else {
            if (c.getSelectedItem().toString().equals("Volts (V)")) {
                return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
            } else {
                return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
            }
        }
    }
    public double convertToResistance(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Current (A)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }
    public double convertToVoltage(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d, String equation) {
        if (equation.equals("V=IR")) {
            return Double.parseDouble(String.valueOf(a.getText())) * Double.parseDouble(String.valueOf(b.getText()));
        } else if (equation.equals("V=E/Q")){
            if (c.getSelectedItem().toString().equals("Charge (C)")) {
                return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
            } else {
                return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
            }
        } else {
            if (c.getSelectedItem().toString().equals("Current (A)")) {
                return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
            } else {
                return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
            }
        }
    }
    public double convertToEnergy(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {

        return Double.parseDouble(String.valueOf(b.getText())) * Double.parseDouble(String.valueOf(a.getText()));

    }
    public double convertToCharge(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Volts (V)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }
    public double convertToPower(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        return Double.parseDouble(String.valueOf(b.getText())) * Double.parseDouble(String.valueOf(a.getText()));
    }


    String selectedEquation = "V=IR";
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
        setContentView(R.layout.activity_generic_multiple_equations);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.voltageEquations, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.voltageArray1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.voltageArray2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.voltageArray3, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        convertFromSpinner = (Spinner) findViewById(R.id.convertFromSpinner);
        convertFromSpinner.setAdapter(adapter1);
        resultSpinner = (Spinner) findViewById(R.id.resultSpinner);
        resultSpinner.setAdapter(adapter1);
        resultTextView = findViewById(R.id.resultTextView);
        convertFromValueInput = findViewById(R.id.enterConvertFromValueEditText);
        convertFromSpinner2 = (Spinner) findViewById(R.id.convertFromSpinner2);
        convertFromSpinner2.setAdapter(adapter1);
        convertFromValueInput2 = findViewById(R.id.enterConvertFromValueEditText2);
        convertFromSpinner2.setSelection(1);
        equationSpinner = (Spinner)findViewById(R.id.equationSpinner);
        equationSpinner.setAdapter(adapter);


        equationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedEquation = equationSpinner.getSelectedItem().toString();
                if (selectedEquation.equals("V=IR")) {
                    resultSpinner.setAdapter(adapter1);
                    convertFromSpinner.setAdapter(adapter1);
                    convertFromSpinner2.setAdapter(adapter1);
                    convertFromSpinner2.setSelection(1);
                } else if (selectedEquation.equals("V=E/Q")){
                    resultSpinner.setAdapter(adapter2);
                    convertFromSpinner.setAdapter(adapter2);
                    convertFromSpinner2.setAdapter(adapter2);
                    convertFromSpinner2.setSelection(1);
                } else {
                    resultSpinner.setAdapter(adapter3);
                    convertFromSpinner.setAdapter(adapter3);
                    convertFromSpinner2.setAdapter(adapter3);
                    convertFromSpinner2.setSelection(1);
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
                mainFunction(adapter1, adapter2, adapter3);
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
                mainFunction(adapter1, adapter2, adapter3);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainFunction(adapter1, adapter2, adapter3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        convertFromSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainFunction(adapter1, adapter2, adapter3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainFunction(adapter1, adapter2, adapter3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void mainFunction(ArrayAdapter adapter1, ArrayAdapter adapter2, ArrayAdapter adapter3) {
        try {
            if (selectedEquation.equals("V=IR")) {

                if ((convertFromSpinner.getSelectedItem().toString().equals("Volts (V)") || convertFromSpinner.getSelectedItem().toString().equals("Current (A)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Volts (V)") || convertFromSpinner2.getSelectedItem().toString().equals("Current (A)"))) {
                    resultSpinner.setSelection(adapter1.getPosition("Resistance (Ω)"));
                    resultTextView.setText(format.format(convertToResistance(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
                } else if ((convertFromSpinner.getSelectedItem().toString().equals("Current (A)") || convertFromSpinner.getSelectedItem().toString().equals("Resistance (Ω)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Current (A)") || convertFromSpinner2.getSelectedItem().toString().equals("Resistance (Ω)"))) {
                    resultSpinner.setSelection(adapter1.getPosition("Volts (V)"));
                    resultTextView.setText(format.format(convertToVoltage(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2, "V=IR")));
                } else if ((convertFromSpinner.getSelectedItem().toString().equals("Volts (V)") || convertFromSpinner.getSelectedItem().toString().equals("Resistance (Ω)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Volts (V)") || convertFromSpinner2.getSelectedItem().toString().equals("Resistance (Ω)"))) {
                    resultSpinner.setSelection(adapter1.getPosition("Current (A)"));
                    resultTextView.setText(format.format(convertToCurrent(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2, "V=IR")));
                }
            } else if (selectedEquation.equals("V=E/Q")){

                if ((convertFromSpinner.getSelectedItem().toString().equals("Volts (V)") || convertFromSpinner.getSelectedItem().toString().equals("Energy (J)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Volts (V)") || convertFromSpinner2.getSelectedItem().toString().equals("Energy (J)"))) {
                    resultSpinner.setSelection(adapter2.getPosition("Charge (C)"));
                    resultTextView.setText(format.format(convertToCharge(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
                } else if ((convertFromSpinner.getSelectedItem().toString().equals("Energy (J)") || convertFromSpinner.getSelectedItem().toString().equals("Charge (C)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Energy (J)") || convertFromSpinner2.getSelectedItem().toString().equals("Charge (C)"))) {
                    resultSpinner.setSelection(adapter2.getPosition("Volts (V)"));
                    resultTextView.setText(format.format(convertToVoltage(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2, "V=E/Q")));
                } else if ((convertFromSpinner.getSelectedItem().toString().equals("Volts (V)") || convertFromSpinner.getSelectedItem().toString().equals("Charge (C)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Volts (V)") || convertFromSpinner2.getSelectedItem().toString().equals("Charge (C)"))) {
                    resultSpinner.setSelection(adapter2.getPosition("Energy (J)"));
                    resultTextView.setText(format.format(convertToEnergy(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
                }
            } else {
                if ((convertFromSpinner.getSelectedItem().toString().equals("Power (W)") || convertFromSpinner.getSelectedItem().toString().equals("Current (A)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Power (W)") || convertFromSpinner2.getSelectedItem().toString().equals("Current (A)"))) {
                    resultSpinner.setSelection(adapter3.getPosition("Volts (V)"));
                    resultTextView.setText(format.format(convertToVoltage(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2, "V=P/I")));
                } else if ((convertFromSpinner.getSelectedItem().toString().equals("Current (A)") || convertFromSpinner.getSelectedItem().toString().equals("Volts (V)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Current (A)") || convertFromSpinner2.getSelectedItem().toString().equals("Volts (V)"))) {
                    resultSpinner.setSelection(adapter3.getPosition("Power (W)"));
                    resultTextView.setText(format.format(convertToPower(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
                } else if ((convertFromSpinner.getSelectedItem().toString().equals("Volts (V)") || convertFromSpinner.getSelectedItem().toString().equals("Power (W)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Volts (V)") || convertFromSpinner2.getSelectedItem().toString().equals("Power (W)"))) {
                    resultSpinner.setSelection(adapter3.getPosition("Current (A)"));
                    resultTextView.setText(format.format(convertToCurrent(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2, "V=P/I")));
                }
            }
        } catch (Exception err) {

        }
    }

}
