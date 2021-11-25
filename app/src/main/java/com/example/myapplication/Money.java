package com.example.myapplication;
import android.app.Activity;

import android.os.Bundle;
import android.os.StrictMode;
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

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Money extends Activity {
    private Spinner convertFromSpinner;
    private TextInputEditText convertFromValueInput;
    private TextView resultTextView;
    private Spinner resultSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_generic);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.Currencies, android.R.layout.simple_spinner_item);
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
                Keys apiKey = new Keys();
                URL url = new URL("https://freecurrencyapi.net/api/v2/latest?apikey=" + apiKey.getCurrencyapiKey() + "&base_currency=" + convertFromSpinner.getSelectedItem());
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                connection.setRequestMethod("GET");
                connection.connect();
                System.out.println(connection.getResponseCode());
                if (connection.getResponseCode() == 200) {
                    Scanner scan = new Scanner(url.openStream());
                    while (scan.hasNext()) {
                        String temp = scan.nextLine();
                        String[] array = temp.split(":");

                        for (int i = 0; i < array.length; i++) {
                            if (array[i].contains(",")) {
                                 String[] array2 = array[i].split(",");
                                 String[] array3 = array[i+1].split(",");
                                if (array2[1].equals("\"" + resultSpinner.getSelectedItem() + "\"")) {
                                    System.out.println(Double.parseDouble(array2[0]));
                                    resultTextView.setText(String.valueOf(Double.parseDouble(String.valueOf(convertFromValueInput.getText())) * Double.parseDouble(array3[0])));
                                }
                            }
                        }
                    }
                }

        } catch (Exception err) {
            System.out.println(err);
        }
    }

}
