package com.example.sayitahminet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView correctNumber, rightText, result;
    EditText guessNumber;
    Button guess;
    int right = 5;
    int number = (int) ((Math.random() * 20) + 1);
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        correctNumber = findViewById(R.id.correctNumber);
        rightText = findViewById(R.id.rightNumber);
        guessNumber = findViewById(R.id.editTextNumber);
        guess = findViewById(R.id.btn_guess);
        result = findViewById(R.id.result);
        rightText.setText("" + right);

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Integer.parseInt(guessNumber.getText().toString()) == number){
                    result.setText("Kazandın, Tebrikler!");
                    correctNumber.setText("" + number);
                } else {
                    right -= 1;
                    rightText.setText("" + right);
                    if(number > Integer.parseInt(guessNumber.getText().toString())){
                        result.setText("Doğru sayı tahmin ettiğinden büyük.");
                    } else {
                        result.setText("Doğru sayı tahmin ettiğinden küçük.");
                    }
                    if(right == 0){
                        correctNumber.setText("" + number);
                        result.setText("Kaybettin.");
                    }
                }
            }
        });


    }



}