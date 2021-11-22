package com.example.myapplication;

import android.app.Activity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.text.TextUtils;
import android.widget.ProgressBar;
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

public class BMI extends Activity {

    EditText weightInput;
    EditText heightInput;
    Spinner weightSpinner;
    Spinner heightSpinner;
    TextView bmiTextView;
    TextView bmiCategory;
    ProgressBar bmiprogressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        weightSpinner = findViewById(R.id.weightSpinner);
        heightSpinner = findViewById(R.id.heightSpinner);
        bmiTextView = findViewById(R.id.bmiTextView);
        bmiCategory = findViewById(R.id.bmiCategory);
        bmiprogressbar = findViewById(R.id.bmiprogressbar);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.bmiArray, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.heightArray, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightSpinner.setAdapter(adapter);
        heightSpinner.setAdapter(adapter1);
        weightInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                calculateBMI(bmiTextView, weightSpinner, heightSpinner, weightInput, heightInput);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        heightInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                calculateBMI(bmiTextView, weightSpinner, heightSpinner, weightInput, heightInput);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        weightSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                calculateBMI(bmiTextView, weightSpinner, heightSpinner, weightInput, heightInput);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        heightSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                calculateBMI(bmiTextView, weightSpinner, heightSpinner, weightInput, heightInput);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void calculateBMI(TextView bmiTextView, Spinner weightSpinner, Spinner heightSpinner, EditText weightInput, EditText heightInput) {
        if (!TextUtils.isEmpty(weightInput.getText().toString()) && !TextUtils.isEmpty(heightInput.getText().toString())) {
            if (weightSpinner.getSelectedItem().equals("Kilograms")) {
                if (heightSpinner.getSelectedItem().equals("Inches")) {
                    double height = Double.parseDouble(String.valueOf(heightInput.getText())) / 39.37;
                    double bmi = Double.parseDouble(String.valueOf(weightInput.getText())) / (height * height);
                    System.out.println(bmi);
                    DecimalFormat df = new DecimalFormat("#.#");
                    bmi = Double.parseDouble(df.format(bmi));
                    bmiTextView.setText("BMI: " + String.valueOf(bmi));
                    if (bmi < 18.5) {
                        bmiCategory.setText("Underweight");
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        bmiCategory.setText("Healthy Weight");
                    } else if (bmi >= 25 && bmi <= 29.9) {
                        bmiCategory.setText("Overweight");
                    } else if (bmi >= 30 && bmi <= 39.9) {
                        bmiCategory.setText("Obese");
                    } else if (bmi >= 40) {
                        bmiCategory.setText("Severely Obese");
                    }
                } else {
                    double height = Double.parseDouble(String.valueOf(heightInput.getText())) / 100;
                    double bmi = Double.parseDouble(String.valueOf(weightInput.getText())) / (height * height);
                    System.out.println(bmi);
                    DecimalFormat df = new DecimalFormat("#.#");
                    bmi = Double.parseDouble(df.format(bmi));
                    bmiTextView.setText("BMI: " + String.valueOf(bmi));
                    if (bmi < 18.5) {
                        bmiCategory.setText("Underweight");
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        bmiCategory.setText("Healthy Weight");
                    } else if (bmi >= 25 && bmi <= 29.9) {
                        bmiCategory.setText("Overweight");
                    } else if (bmi >= 30 && bmi <= 39.9) {
                        bmiCategory.setText("Obese");
                    } else if (bmi >= 40) {
                        bmiCategory.setText("Severely Obese");
                    }
                }
            } else {
                if (heightSpinner.getSelectedItem().equals("Inches")) {
                    double height = Double.parseDouble(String.valueOf(heightInput.getText())) / 39.37;
                    double weight = Double.parseDouble(String.valueOf(weightInput.getText())) / 2.205;
                    double bmi = Double.parseDouble(String.valueOf(weight)) / (height * height);
                    System.out.println(bmi);
                    DecimalFormat df = new DecimalFormat("#.#");
                    bmi = Double.parseDouble(df.format(bmi));
                    bmiTextView.setText("BMI: " + String.valueOf(bmi));
                    if (bmi < 18.5) {
                        bmiCategory.setText("Underweight");
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        bmiCategory.setText("Healthy Weight");
                    } else if (bmi >= 25 && bmi <= 29.9) {
                        bmiCategory.setText("Overweight");
                    } else if (bmi >= 30 && bmi <= 39.9) {
                        bmiCategory.setText("Obese");
                    } else if (bmi >= 40) {
                        bmiCategory.setText("Severely Obese");
                    }
                } else {
                    double height = Double.parseDouble(String.valueOf(heightInput.getText())) / 100;
                    double weight = Double.parseDouble(String.valueOf(weightInput.getText())) / 2.205;
                    double bmi = Double.parseDouble(String.valueOf(weight)) / (height * height);
                    System.out.println(bmi);
                    DecimalFormat df = new DecimalFormat("#.#");
                    bmi = Double.parseDouble(df.format(bmi));
                    bmiTextView.setText("BMI: " + String.valueOf(bmi));
                    if (bmi < 18.5) {
                        bmiCategory.setText("Underweight");
                    } else if (bmi >= 18.5 && bmi <= 24.9) {
                        bmiCategory.setText("Healthy Weight");
                    } else if (bmi >= 25 && bmi <= 29.9) {
                        bmiCategory.setText("Overweight");
                    } else if (bmi >= 30 && bmi <= 39.9) {
                        bmiCategory.setText("Obese");
                    } else if (bmi >= 40) {
                        bmiCategory.setText("Severely Obese");
                    }
                }
            }
        }
    }
}