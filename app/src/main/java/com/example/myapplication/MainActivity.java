package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etFirstNum;
    EditText etSecondNum;
    TextView tvSign;
    TextView tvResult;
    Button btnPlus;
    Button btnMinus;
    Button btnDivide;
    Button btnMultiply;
    Button btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etFirstNum = findViewById(R.id.etFirstNum);
        etSecondNum = findViewById(R.id.etSecondNum);
        tvSign = findViewById(R.id.tvSign);
        tvResult = findViewById(R.id.tvResult);
        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivide = findViewById(R.id.btnDivide);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnClear = findViewById(R.id.btnClear);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSign.setText("+");
                DoOperation();
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSign.setText("-");
                DoOperation();
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSign.setText("/");
                DoOperation();
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSign.setText("*");
                DoOperation();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etFirstNum.setText("");
                etSecondNum.setText("");
                tvResult.setText("");
                tvSign.setText("?");
            }
        });

        etFirstNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                DoOperation();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });

        etSecondNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                DoOperation();
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
        });
    }

    private void DoOperation() {
        if (etFirstNum.getText().toString().isBlank()) return;
        if (etSecondNum.getText().toString().isBlank()) return;

        double firstNum = Double.parseDouble(etFirstNum.getText().toString());
        double secondNum = Double.parseDouble(etSecondNum.getText().toString());
        double result = 0;

        switch (tvSign.getText().toString()) {
            case "+": {
                result = firstNum + secondNum;
                break;
            }

            case "-": {
                result = firstNum - secondNum;
                break;
            }

            case "*": {
                result = firstNum * secondNum;
                break;
            }

            case "/": {
                if (secondNum == 0) {
                    tvResult.setText("ERR");
                    return;
                }
                else {
                 result = firstNum / secondNum;
                }
                break;
            }

            default: {
                return;
            }
        }

        tvResult.setText(String.valueOf(result));
    }
}