package com.example.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import android.widget.Toast;
import android.text.method.BaseMovementMethod;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import android.util.Log;
import android.widget.Toast;

public class Calculator extends Activity {
    boolean decimalClicked = false;
    String inputString = "";
    double currentValue = 0;
    List<Double> inputs = new ArrayList<Double>();
    double previousValue;
    private TextView previousEquation;
    private TextView editTextTextPersonName;
    private Button equalsButton, decimalButton, button21, button24, button25, button26, button27, button28, button29, button30, button31, button32, button33, button34, button35, button36, button37, button38, button39, button40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        previousEquation = findViewById(R.id.previousEquation);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        editTextTextPersonName.setMovementMethod(new ScrollingMovementMethod());
        editTextTextPersonName.setHorizontallyScrolling(true);
        equalsButton = findViewById(R.id.equalsButton);
        decimalButton = findViewById(R.id.decimalButton);
        button21 = findViewById(R.id.button21);
        button24 = findViewById(R.id.button24);
        button25 = findViewById(R.id.button25);
        button26 = findViewById(R.id.button26);
        button27 = findViewById(R.id.button27);
        button28 = findViewById(R.id.button28);
        button29 = findViewById(R.id.button29);
        button30 = findViewById(R.id.button30);
        button31 = findViewById(R.id.button31);
        button32 = findViewById(R.id.button32);
        button33 = findViewById(R.id.button33);
        button34 = findViewById(R.id.button34);
        button35 = findViewById(R.id.button35);
        button36 = findViewById(R.id.button36);
        button37 = findViewById(R.id.button37);
        button38 = findViewById(R.id.button38);
        button39 = findViewById(R.id.button39);
        button40 = findViewById(R.id.button40);


        equalsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputString.length() != 0) {
                    if (inputString.charAt(inputString.length() - 1) != '(' && inputString.charAt(inputString.length() - 1) != '.' && inputString.charAt(inputString.length() - 1) != '*' && inputString.charAt(inputString.length() - 1) != '/' && inputString.charAt(inputString.length() - 1) != '-' && inputString.charAt(inputString.length() - 1) != '+') {
                        decimalClicked = false;
                        double result = 0;
                        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
                        try {
                            result = (double) engine.eval(inputString);
                        } catch (ScriptException e) {
                            Toast.makeText(Calculator.this, "Exception has occurred", Toast.LENGTH_SHORT).show();
                        }
                        previousEquation.setText(String.valueOf(result));
                        inputString = "";
                        editTextTextPersonName.setText(inputString);
                    }
                }
            }
        });
        decimalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!decimalClicked) {
                    inputString += ".";
                    decimalClicked = true;
                }
                editTextTextPersonName.setText(inputString);
            }
        });
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //left bracket
                if (inputString.length() > 0) {
                if (inputString.charAt(inputString.length() - 1) != '.' && (inputString.charAt(inputString.length() -1) == '*') || inputString.charAt(inputString.length() -1) == '+' || inputString.charAt(inputString.length() -1) == '/' || inputString.charAt(inputString.length() -1) == '-') {
                    inputString += "(";
                    editTextTextPersonName.setText(inputString);
                    decimalClicked = false;
                }
                } else {
                    inputString += "(";
                    editTextTextPersonName.setText(inputString);
                    decimalClicked = false;
                }

            }
        });
        button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentVal = String.valueOf(currentValue);
                if (!inputString.equals("") || currentVal.equals("0")) {
                    if (inputString.substring(inputString.length() - 1).equals(".")) {
                        decimalClicked = false;
                    }
                    inputString = inputString.substring(0, inputString.length() - 1);
                }

                editTextTextPersonName.setText(inputString);
            }
        });
        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() - 1) != ')') {
                        inputString += "0";
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    inputString += "0";
                    editTextTextPersonName.setText(inputString);
                }
            }
        });
        button26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() -1) != '/' && inputString.charAt(inputString.length() -1) != '+' && inputString.charAt(inputString.length() -1) != '-' && inputString.charAt(inputString.length() -1) != '*') {
                        inputString += "+";
                        decimalClicked = false;
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    if (!previousEquation.equals("")) {
                        inputString += previousEquation.getText() + "+";
                        decimalClicked = false;
                        editTextTextPersonName.setText(inputString);
                    }
                }
            }
        });
        button27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() - 1) != ')') {
                        inputString += "3";
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    inputString += "3";
                    editTextTextPersonName.setText(inputString);
                }
            }
        });
        button28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() - 1) != ')') {
                        inputString += "2";
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    inputString += "2";
                    editTextTextPersonName.setText(inputString);
                }
            }
        });
        button29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() - 1) != ')') {
                        inputString += "1";
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    inputString += "1";
                    editTextTextPersonName.setText(inputString);

                }

            }
        });
        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {

                        inputString += "-";
                        decimalClicked = false;
                        editTextTextPersonName.setText(inputString);

                } else {
                    if (!previousEquation.equals("")) {
                        inputString += previousEquation.getText() + "-";
                        decimalClicked = false;
                        editTextTextPersonName.setText(inputString);
                    }
                }
            }
        });
        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() - 1) != ')') {
                        inputString += "6";
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    inputString += "6";
                    editTextTextPersonName.setText(inputString);
                }

            }
        });
        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() - 1) != ')') {
                        inputString += "5";
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    inputString += "5";
                    editTextTextPersonName.setText(inputString);
                }
            }
        });
        button33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() - 1) != ')') {
                        inputString += "4";
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    inputString += "4";
                    editTextTextPersonName.setText(inputString);
                }
            }
        });
        button34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() -1) != '/' && inputString.charAt(inputString.length() -1) != '+' && inputString.charAt(inputString.length() -1) != '-' && inputString.charAt(inputString.length() -1) != '*') {
                        inputString += "*";
                        decimalClicked = false;
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    if (!previousEquation.equals("")) {
                        inputString += previousEquation.getText() + "*";
                        decimalClicked = false;
                        editTextTextPersonName.setText(inputString);
                    }
                }
            }
        });
        button35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() - 1) != ')') {
                        inputString += "9";
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    inputString += "9";
                    editTextTextPersonName.setText(inputString);
                }
            }
        });
        button36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() - 1) != ')') {
                        inputString += "8";
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    inputString += "8";
                    editTextTextPersonName.setText(inputString);
                }
            }
        });
        button37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() - 1) != ')') {
                        inputString += "7";
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    inputString += "7";
                    editTextTextPersonName.setText(inputString);
                }
            }
        });
        button38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() -1) != '/' && inputString.charAt(inputString.length() -1) != '+' && inputString.charAt(inputString.length() -1) != '-' && inputString.charAt(inputString.length() -1) != '*') {
                        inputString += "/";
                        decimalClicked = false;
                        editTextTextPersonName.setText(inputString);
                    }
                } else {
                    if (!previousEquation.equals("")) {
                        inputString += previousEquation.getText() + "/";
                        decimalClicked = false;
                        editTextTextPersonName.setText(inputString);
                    }
                }
            }
        });
        button39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!inputString.equals("")) {
                    if (inputString.charAt(inputString.length() -1) != '/' && inputString.charAt(inputString.length() -1) != '+' && inputString.charAt(inputString.length() -1) != '-' && inputString.charAt(inputString.length() -1) != '*' && inputString.charAt(inputString.length() -1) != '(' && inputString.charAt(inputString.length() -1) != '.') {
                        int leftBracketCount = 0;
                        int rightBracketCount = 0;
                        for (int i = 0; i < inputString.length(); i++) {
                            if (inputString.charAt(i) == '(') leftBracketCount++;
                            else if (inputString.charAt(i) == ')') rightBracketCount++;
                        }
                        if (leftBracketCount == rightBracketCount + 1) {
                            inputString += ")";
                            editTextTextPersonName.setText(inputString);
                            decimalClicked = false;
                        }
                    }
                }
            }
        });
        button40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                previousValue = 0;
                currentValue = 0;
                inputString = "";
                decimalClicked = false;
                editTextTextPersonName.setText(inputString);
                previousEquation.setText(inputString);
            }
        });
    }
}
