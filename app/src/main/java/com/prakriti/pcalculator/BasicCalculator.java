package com.prakriti.pcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BasicCalculator extends AppCompatActivity implements View.OnClickListener {

    private Button button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_0,
            button_add, button_subtract, button_multiply, button_divide, button_equal, button_clear;
    private TextView txtCalculations, txtResultBar;

    private enum OPERATOR { ADD, SUBTRACT, MULTIPLY, DIVIDE, EQUAL }

    // instance vars
    private String currentNumber = "", numberAtLeft, numberAtRight;
    private OPERATOR currentOperator;
    private int calculationResult = 0;
    private String calcString = "";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_calculator);

        button_1 = findViewById(R.id.b1);
        button_2 = findViewById(R.id.b2);
        button_3 = findViewById(R.id.b3);
        button_4 = findViewById(R.id.b4);
        button_5 = findViewById(R.id.b5);
        button_6 = findViewById(R.id.b6);
        button_7 = findViewById(R.id.b7);
        button_8 = findViewById(R.id.b8);
        button_9 = findViewById(R.id.b9);
        button_0 = findViewById(R.id.b0);
        button_add = findViewById(R.id.add);
        button_subtract = findViewById(R.id.subtract);
        button_multiply = findViewById(R.id.multiply);
        button_divide = findViewById(R.id.divide);
        button_equal = findViewById(R.id.equal);
        button_clear = findViewById(R.id.clear);

        txtCalculations = findViewById(R.id.txtCalculations);
        txtResultBar = findViewById(R.id.txtResultBar);
        
        button_0.setOnClickListener(this);
        button_1.setOnClickListener(this);
        button_2.setOnClickListener(this);
        button_3.setOnClickListener(this);
        button_4.setOnClickListener(this);
        button_5.setOnClickListener(this);
        button_6.setOnClickListener(this);
        button_7.setOnClickListener(this);
        button_8.setOnClickListener(this);
        button_9.setOnClickListener(this);
        button_clear.setOnClickListener(this);
        button_equal.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_subtract.setOnClickListener(this);
        button_multiply.setOnClickListener(this);
        button_divide.setOnClickListener(this);
        
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b0:
                numberIsTapped(0);
                break;
            case R.id.b1:
                numberIsTapped(1);
                break;
            case R.id.b2:
                numberIsTapped(2);
                break;
            case R.id.b3:
                numberIsTapped(3);
                break;
            case R.id.b4:
                numberIsTapped(4);
                break;
            case R.id.b5:
                numberIsTapped(5);
                break;
            case R.id.b6:
                numberIsTapped(6);
                break;
            case R.id.b7:
                numberIsTapped(7);
                break;
            case R.id.b8:
                numberIsTapped(8);
                break;
            case R.id.b9:
                numberIsTapped(9);
                break;
            case R.id.add:
                operatorIsTapped(OPERATOR.ADD);
                calcString += " + ";
                break;
            case R.id.subtract:
                operatorIsTapped(OPERATOR.SUBTRACT);
                calcString += " - ";
                break;
            case R.id.multiply:
                operatorIsTapped(OPERATOR.MULTIPLY);
                calcString += " * ";
                break;
            case R.id.divide:
                operatorIsTapped(OPERATOR.DIVIDE);
                calcString += " / ";
                break;
            case R.id.equal:
                operatorIsTapped(OPERATOR.EQUAL);
                break;
            case R.id.clear:
                clearTapped();
                break;
        }
        txtResultBar.setText(calcString);
    }

    private void numberIsTapped(int tappedNumber) {
        currentNumber += String.valueOf(tappedNumber);
        txtCalculations.setText(currentNumber);
        calcString = currentNumber;
        txtResultBar.setText(calcString);
    }

    private void operatorIsTapped(OPERATOR tappedOperator) {
        if (currentOperator != null) {
            if (currentNumber != "") {
                numberAtRight = currentNumber;
                currentNumber = "";

                switch (currentOperator) {

                    case ADD:
                        calculationResult = Integer.parseInt(numberAtLeft) + Integer.parseInt(numberAtRight);
                        break;
                    case SUBTRACT:
                        calculationResult = Integer.parseInt(numberAtLeft) - Integer.parseInt(numberAtRight);
                        break;
                    case MULTIPLY:
                        calculationResult = Integer.parseInt(numberAtLeft) * Integer.parseInt(numberAtRight);
                        break;
                    case DIVIDE:
                        calculationResult = Integer.parseInt(numberAtLeft) / Integer.parseInt(numberAtRight);
                        break;
                }
                numberAtLeft = String.valueOf(calculationResult);
                txtCalculations.setText(numberAtLeft);
                calcString = numberAtLeft;
            }
        }
        else {
            numberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;
    }

    private void clearTapped() {
        numberAtLeft = "";
        numberAtRight = "";
        calculationResult = 0;
        currentNumber = "0";
        currentOperator = null;
        calcString = "0";
        txtCalculations.setText("0");
    }
}