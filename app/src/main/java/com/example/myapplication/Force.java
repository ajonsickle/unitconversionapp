package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputEditText;

public class Force extends Activity {

    public double convertToMass(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Acceleration (m/s^2)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }
    public double convertToAcceleration(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Mass (Kg)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }
    public double convertToForce(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d, String equation) {
        if (equation.equals("F=MA")) {
            return Double.parseDouble(String.valueOf(a.getText())) * Double.parseDouble(String.valueOf(b.getText()));
        } else if (equation.equals("F=E/D")){
            if (c.getSelectedItem().toString().equals("Distance (m)")) {
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
    public double convertToDistance(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Force (N)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }
    public double convertToSpringConstant(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Extension (m)")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }
    public double convertToExtension(TextInputEditText a, TextInputEditText b, Spinner c, Spinner d) {
        if (c.getSelectedItem().toString().equals("Spring Constant")) {
            return Double.parseDouble(String.valueOf(b.getText())) / Double.parseDouble(String.valueOf(a.getText()));
        } else {
            return Double.parseDouble(String.valueOf(a.getText())) / Double.parseDouble(String.valueOf(b.getText()));
        }
    }

    String selectedEquation = "F=MA";
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

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.forceEquationArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.forceArray1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.forceArray2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.forceArray3, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

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
                if (selectedEquation.equals("F=MA")) {
                    resultSpinner.setAdapter(adapter1);
                    convertFromSpinner.setAdapter(adapter1);
                    convertFromSpinner2.setAdapter(adapter1);
                    convertFromSpinner2.setSelection(1);
                } else if (selectedEquation.equals("F=E/D")){
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
        if (selectedEquation.equals("F=MA")) {

            if ((convertFromSpinner.getSelectedItem().toString().equals("Force (N)") || convertFromSpinner.getSelectedItem().toString().equals("Mass (Kg)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Force (N)") || convertFromSpinner2.getSelectedItem().toString().equals("Mass (Kg)"))) {
                resultSpinner.setSelection(adapter1.getPosition("Acceleration (m/s^2)"));
                resultTextView.setText(format.format(convertToAcceleration(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
            } else if ((convertFromSpinner.getSelectedItem().toString().equals("Mass (Kg)") || convertFromSpinner.getSelectedItem().toString().equals("Acceleration (m/s^2)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Mass (Kg)") || convertFromSpinner2.getSelectedItem().toString().equals("Acceleration (m/s^2)"))) {
                resultSpinner.setSelection(adapter1.getPosition("Force (N)"));
                resultTextView.setText(format.format(convertToForce(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2, "F=MA")));
            } else if ((convertFromSpinner.getSelectedItem().toString().equals("Force (N)") || convertFromSpinner.getSelectedItem().toString().equals("Acceleration (m/s^2)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Force (N)") || convertFromSpinner2.getSelectedItem().toString().equals("Acceleration (m/s^2)"))) {
                resultSpinner.setSelection(adapter1.getPosition("Mass (Kg)"));
                resultTextView.setText(format.format(convertToMass(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
            }
        } else if (selectedEquation.equals("F=E/D")){

            if ((convertFromSpinner.getSelectedItem().toString().equals("Force (N)") || convertFromSpinner.getSelectedItem().toString().equals("Energy (J)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Force (N)") || convertFromSpinner2.getSelectedItem().toString().equals("Energy (J)"))) {
                resultSpinner.setSelection(adapter2.getPosition("Distance (m)"));
                resultTextView.setText(format.format(convertToDistance(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
            } else if ((convertFromSpinner.getSelectedItem().toString().equals("Energy (J)") || convertFromSpinner.getSelectedItem().toString().equals("Distance (m)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Energy (J)") || convertFromSpinner2.getSelectedItem().toString().equals("Distance (m)"))) {
                resultSpinner.setSelection(adapter2.getPosition("Force (N)"));
                resultTextView.setText(format.format(convertToForce(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2, "F=E/D")));
            } else if ((convertFromSpinner.getSelectedItem().toString().equals("Force (N)") || convertFromSpinner.getSelectedItem().toString().equals("Distance (m)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Force (N)") || convertFromSpinner2.getSelectedItem().toString().equals("Distance (m)"))) {
                resultSpinner.setSelection(adapter2.getPosition("Energy (J)"));
                resultTextView.setText(format.format(convertToEnergy(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
            }
        } else {
            if ((convertFromSpinner.getSelectedItem().toString().equals("Spring Constant") || convertFromSpinner.getSelectedItem().toString().equals("Extension (m)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Spring Constant") || convertFromSpinner2.getSelectedItem().toString().equals("Extension (m)"))) {
                resultSpinner.setSelection(adapter3.getPosition("Force (N)"));
                resultTextView.setText(format.format(convertToForce(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2, "F=KE")));
            } else if ((convertFromSpinner.getSelectedItem().toString().equals("Extension (m)") || convertFromSpinner.getSelectedItem().toString().equals("Force (N)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Extension (m)") || convertFromSpinner2.getSelectedItem().toString().equals("Force (N)"))) {
                resultSpinner.setSelection(adapter3.getPosition("Spring Constant"));
                resultTextView.setText(format.format(convertToSpringConstant(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
            } else if ((convertFromSpinner.getSelectedItem().toString().equals("Spring Constant") || convertFromSpinner.getSelectedItem().toString().equals("Force (N)")) && (convertFromSpinner2.getSelectedItem().toString().equals("Spring Constant") || convertFromSpinner2.getSelectedItem().toString().equals("Force (N)"))) {
                resultSpinner.setSelection(adapter3.getPosition("Extension (m)"));
                resultTextView.setText(format.format(convertToExtension(convertFromValueInput, convertFromValueInput2, convertFromSpinner, convertFromSpinner2)));
            }
        }
    } catch (Exception err) {

    }
}

}
