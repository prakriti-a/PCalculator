package com.prakriti.pcalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtPercent, edtNumber;
    private Button btnCalculate, btnBasicCalculator, btnClear;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.BLACK);

        edtPercent = findViewById(R.id.edtPercent);
        edtNumber = findViewById(R.id.edtNumber);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        btnBasicCalculator = findViewById(R.id.btnBasicCalculator);
        btnClear = findViewById(R.id.btnClear);

        btnCalculate.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        btnBasicCalculator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnCalculate:
                calculatePercentage();
                break;

            case R.id.btnClear:
                edtNumber.setText("");
                edtPercent.setText("");
                txtResult.setText("");
                break;

            case R.id.btnBasicCalculator:
                Intent nextPage = new Intent(MainActivity.this, BasicCalculator.class);
                startActivity(nextPage);
                break;
        }
    }

    private void calculatePercentage() {
        try {
            Float value = Float.parseFloat(edtNumber.getText().toString());
            Float percentValue = Float.parseFloat(edtPercent.getText().toString());
            if(percentValue > 100) {
                edtNumber.setText("0");
                edtPercent.setText("0");
                txtResult.setText("- INVALID INPUT -");
            }
            else {
                Float result = (percentValue / 100) * value;
                txtResult.setText(Float.toString(result));
            }
        }
        catch (NumberFormatException e) {
            edtNumber.setText("0");
            edtPercent.setText("0");
            txtResult.setText("- INVALID INPUT -");
        }
        catch (Exception f) {
            edtNumber.setText("0");
            edtPercent.setText("0");
            txtResult.setText("- INVALID INPUT -");
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return super.onOptionsItemSelected(item);
//    }
}