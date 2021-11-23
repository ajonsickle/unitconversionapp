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


import com.google.android.material.textfield.TextInputEditText;

public class Power extends Activity {

    public double convertToCurrent(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Voltage (V)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }
    public double convertToVoltage(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Current (A)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }
    public double convertToPower(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d, String equation) {
        if (equation.equals("P=E/T")) {
            if (c.getSelectedItem().toString().equals("Time (s)")) {
                return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
            } else {
                return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
            }
        } else {
                return Double.parseDouble(String.valueOf(a.getText())) * Double.parseDouble(String.valueOf(b.getText()));
        }
    }
    public double convertToEnergy(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {

        return Double.parseDouble(String.valueOf(b.getText())) * Double.parseDouble(String.valueOf(a.getText()));

    }
    public double convertToTime(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Power (W)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }

    String selectedEquation = "P=E/T";
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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_generic_multiple_equations);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.powerEquationArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.powerArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.powerArray1, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        convertFromSpinner = (Spinner) findViewById(R.id.convertFromSpinner);
        convertFromSpinner.setAdapter(adapter1);
        resultSpinner = (Spinner) findViewById(R.id.resultSpinner);
        resultSpinner.setAdapter(adapter1);
        resultTextView = findViewById(R.id.resultTextView);
        convertFromValueInput = findViewById(R.id.enterConvertFromValueEditText);
        convertFromSpinner2 = (Spinner) findViewById(R.id.convertFromSpinner2);
        convertFromSpinner2.setAdapter(adapter1);
        convertFromSpinner2.setSelection(1);
        convertFromValueInput2 = findViewById(R.id.enterConvertFromValueEditText2);
        equationSpinner = (Spinner)findViewById(R.id.equationSpinner);
        equationSpinner.setAdapter(adapter);


        equationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedEquation = equationSpinner.getSelectedItem().toString();
                if (selectedEquation.equals("P=E/T")) {
                    resultSpinner.setAdapter(adapter1);
                    convertFromSpinner.setAdapter(adapter1);
                    convertFromSpinner2.setAdapter(adapter1);
                    convertFromSpinner2.setSelection(1);
                } else {
                    resultSpinner.setAdapter(adapter2);
                    convertFromSpinner.setAdapter(adapter2);
                    convertFromSpinner2.setAdapter(adapter2);
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
                mainFunction(adapter1, adapter2);

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
                mainFunction(adapter1, adapter2);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainFunction(adapter1, adapter2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        convertFromSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainFunction(adapter1, adapter2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mainFunction(adapter1, adapter2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void mainFunction(ArrayAdapter adapter1, ArrayAdapter adapter2) {
        try {
            if (selectedEquation.equals("P=E/T")) {

                if ((convertFromSpinner.getSelectedItem().toString().equals("Power (W)") || convertFromSpinner.getSelectedItem().toString().equals("Energy (J)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Power (W)") || convertFromSpinner2.getSelectedItem().toString().equals("Energy (J)"))) {
                    resultSpinner.setSelection(adapter1.getPosition("Time (s)"));
                    resultTextView.setText(format.format(convertToTime(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
                } else if ((convertFromSpinner.getSelectedItem().toString().equals("Energy (J)") || convertFromSpinner.getSelectedItem().toString().equals("Time (s)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Energy (J)") || convertFromSpinner2.getSelectedItem().toString().equals("Time (s)"))) {
                    resultSpinner.setSelection(adapter1.getPosition("Power (W)"));
                    resultTextView.setText(format.format(convertToPower(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2, "P=E/T")));
                } else if ((convertFromSpinner.getSelectedItem().toString().equals("Power (W)") || convertFromSpinner.getSelectedItem().toString().equals("Time (s)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Power (W)") || convertFromSpinner2.getSelectedItem().toString().equals("Time (s)"))) {
                    resultSpinner.setSelection(adapter1.getPosition("Energy (J)"));
                    resultTextView.setText(format.format(convertToEnergy(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
                }
            } else {

                if ((convertFromSpinner.getSelectedItem().toString().equals("Power (W)") || convertFromSpinner.getSelectedItem().toString().equals("Current (A)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Power (W)") || convertFromSpinner2.getSelectedItem().toString().equals("Current (A)"))) {
                    resultSpinner.setSelection(adapter2.getPosition("Volts (V)"));
                    resultTextView.setText(format.format(convertToVoltage(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
                } else if ((convertFromSpinner.getSelectedItem().toString().equals("Current (A)") || convertFromSpinner.getSelectedItem().toString().equals("Volts (V)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Current (A)") || convertFromSpinner2.getSelectedItem().toString().equals("Volts (V)"))) {
                    resultSpinner.setSelection(adapter2.getPosition("Power (W)"));
                    resultTextView.setText(format.format(convertToPower(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2, "P=IV")));
                } else if ((convertFromSpinner.getSelectedItem().toString().equals("Power (W)") || convertFromSpinner.getSelectedItem().toString().equals("Volts (V)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Power (W)") || convertFromSpinner2.getSelectedItem().toString().equals("Volts (V)"))) {
                    resultSpinner.setSelection(adapter2.getPosition("Current (A)"));
                    resultTextView.setText(format.format(convertToCurrent(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
                }
            }
        } catch (Exception err) {

        }
    }

}
