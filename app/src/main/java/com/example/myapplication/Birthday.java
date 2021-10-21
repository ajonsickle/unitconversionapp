package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import java.util.concurrent.TimeUnit;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import java.text.DecimalFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.math.BigDecimal;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Text;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Birthday extends Activity {

    long milliseconds = 0;
    long milliseconds1 = 0;
    DatePickerDialog datePickerDialog;
    DatePickerDialog datePickerDialog2;
    TextView startingDateText;
    TextView endingDateText;
    Button startingDate;
    Button endingDate;
    TextView years;
    TextView months;
    TextView weeks;
    TextView hours;
    TextView days;
    TextView minutes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        startingDateText = findViewById(R.id.startingDateText);
        endingDateText = findViewById(R.id.endingDateText);
        startingDate = findViewById(R.id.startingDate);
        endingDate = findViewById(R.id.endingDate);
        years = findViewById(R.id.years);
        months = findViewById(R.id.months);
        weeks = findViewById(R.id.weeks);
        hours = findViewById(R.id.hours);
        days = findViewById(R.id.days);
        minutes = findViewById(R.id.minutes);
        initDatePicker();
        initDatePicker2();
        endingDate.setText(todaysDate());
        startingDate.setText(todaysDate());
        endingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker();
            }
        });
        startingDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDatePicker2();
            }
        });
    }
    private String todaysDate() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }
    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String date = makeDateString(i2, i1, i);
                endingDate.setText(date);
                Calendar calendar = Calendar.getInstance();
                calendar.set(i, i1, i2);
                milliseconds = calendar.getTimeInMillis();
                long minutesPassed = TimeUnit.MILLISECONDS.toMinutes(milliseconds - milliseconds1);
                years.setText("Years:" + "\n" + String.valueOf(Math.round((milliseconds - milliseconds1) / 3.154e+10)));
                months.setText("Months:" + "\n" + String.valueOf(Math.round((milliseconds - milliseconds1) / 2.628e+9)));
                weeks.setText("Weeks:" + "\n" + String.valueOf(Math.round((milliseconds - milliseconds1) / 6.048e+8)));
                hours.setText("Hours:" + "\n" + String.valueOf(Math.round((milliseconds - milliseconds1) / 3.6e+6)));
                days.setText("Days:" + "\n" + String.valueOf(Math.round((milliseconds - milliseconds1) / 8.64e+7)));
                minutes.setText("Minutes:" + "\n" + String.valueOf(minutesPassed));

            }
        };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_DARK;
        milliseconds = calendar.getTimeInMillis();
        System.out.println(milliseconds);
        datePickerDialog = new DatePickerDialog(this,style, dateSetListener, year, month, day);
    }
    private void initDatePicker2() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String date = makeDateString(i2, i1, i);
                startingDate.setText(date);
                Calendar calendar = Calendar.getInstance();
                calendar.set(i, i1, i2);
                milliseconds1 = calendar.getTimeInMillis();
                long minutesPassed = TimeUnit.MILLISECONDS.toMinutes(milliseconds - milliseconds1);
                years.setText("Years:" + "\n" + String.valueOf(Math.round((milliseconds - milliseconds1) / 3.154e+10)));
                months.setText("Months:" + "\n" + String.valueOf(Math.round((milliseconds - milliseconds1) / 2.628e+9)));
                weeks.setText("Weeks:" + "\n" + String.valueOf(Math.round((milliseconds - milliseconds1) / 6.048e+8)));
                hours.setText("Hours:" + "\n" + String.valueOf(Math.round((milliseconds - milliseconds1) / 3.6e+6)));
                days.setText("Days:" + "\n" + String.valueOf(Math.round((milliseconds - milliseconds1) / 8.64e+7)));
                minutes.setText("Minutes:" + "\n" + String.valueOf(minutesPassed));
            }
        };
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int style = AlertDialog.THEME_HOLO_DARK;
        milliseconds1 = calendar.getTimeInMillis();
        System.out.println(milliseconds1);
        datePickerDialog2 = new DatePickerDialog(this,style, dateSetListener, year, month, day);
    }
    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + ", " + year;
    }
    private String getMonthFormat(int month1) {
        String month;
        switch (month1) {
            case 0:
                month = "Jan";
                break;
            case 1:
                month = "Feb";
                break;
            case 2:
                month = "Mar";
                break;
            case 3:
                month = "Apr";
                break;
            case 4:
                month = "May";
                break;
            case 5:
                month = "Jun";
                break;
            case 6:
                month = "Jul";
                break;
            case 7:
                month = "Aug";
                break;
            case 8:
                month = "Sep";
                break;
            case 9:
                month = "Oct";
                break;
            case 10:
                month = "Nov";
                break;
            case 11:
                month = "Dec";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + month1);
        }
        return month;
    }
    public void openDatePicker() {
        datePickerDialog.show();
    }
    public void openDatePicker2() {
        datePickerDialog2.show();
    }
}
