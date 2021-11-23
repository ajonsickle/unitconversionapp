package com.example.myapplication;
import android.app.Activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Area extends Activity {
    private Spinner convertFromSpinner;
    private TextInputEditText convertFromValueInput;
    private TextView resultTextView;
    private Spinner resultSpinner;
    public double convertToSquareMetres(Spinner a, TextInputEditText b) {
        try {
            String input = b.getText().toString().trim();
            if (input.isEmpty()) {
                return 0;
            }
            double d = 0;
            switch (a.getSelectedItem().toString()) {
                case "Square Metres":
                    d = (Double.parseDouble(input));
                    break;
                case "Square Miles":
                    d = (Double.parseDouble(input)) * 2.59e+6;
                    break;
                case "Square Yards":
                    d = (Double.parseDouble(input) / 1.196);
                    break;
                case "Square Kilometres":
                    d = (Double.parseDouble(input) * 1e+6);
                    break;
                case "Square Centimetres":
                    d = (Double.parseDouble(input) / 10000);
                    break;
                case "Square Millimetres":
                    d = (Double.parseDouble(input) / 1e+6);
                    break;
                case "Square Feet":
                    d = (Double.parseDouble(input) / 10.764);
                    break;
                case "Square Inches":
                    d = (Double.parseDouble(input) / 1550);
                    break;
                case "Square Decimetres":
                    d = (Double.parseDouble(input) / 100);
                    break;
                case "Square Decametres":
                    d = (Double.parseDouble(input) * 100);
                    break;
                case "Acres":
                    d = (Double.parseDouble(input) * 4047);
                    break;
                case "Hectares":
                    d = (Double.parseDouble(input) * 10000);
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
    public double convertFromSquareMetres(Spinner a, double b) {
        double d = 0;
        switch (a.getSelectedItem().toString()) {

            case "Square Metres":
                d = b;
                break;
            case "Square Miles":
                d = b / 2.59e+6;
                break;
            case "Square Yards":
                d = b * 1.196;
                break;
            case "Square Kilometres":
                d = b / 1e+6;
                break;
            case "Square Centimetres":
                d = b * 10000;
                break;
            case "Square Millimetres":
                d = b * 1e+6;
                break;
            case "Square Feet":
                d = b * 10.764;
                break;
            case "Square Inches":
                d = b * 1550;
                break;
            case "Square Decimetres":
                d = b * 100;
                break;
            case "Square Decametres":
                d = b / 100;
                break;
            case "Acres":
                d = b / 4047;
                break;
            case "Hectares":
                d = b / 10000;
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
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_generic);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.convertFromAreaArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.convertFromAreaArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        convertFromSpinner = (Spinner)findViewById(R.id.convertFromSpinner);
        convertFromSpinner.setAdapter(adapter);
        resultSpinner = (Spinner)findViewById(R.id.resultSpinner);
        resultSpinner.setAdapter(adapter1);
        resultTextView = findViewById(R.id.resultTextView);
        convertFromValueInput = findViewById(R.id.enterConvertFromValueEditText);
        DecimalFormat format = new DecimalFormat("#.######");
        convertFromValueInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                resultTextView.setText(format.format(convertFromSquareMetres(resultSpinner, convertToSquareMetres(convertFromSpinner, convertFromValueInput))));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        convertFromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(format.format(convertFromSquareMetres(resultSpinner, convertToSquareMetres(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        resultSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                resultTextView.setText(format.format(convertFromSquareMetres(resultSpinner, convertToSquareMetres(convertFromSpinner, convertFromValueInput))));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
