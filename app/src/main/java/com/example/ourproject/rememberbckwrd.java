package com.example.ourproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class rememberbckwrd extends AppCompatActivity {

    private static final int DELAY_MS = 1000; // Delay in milliseconds
    private TextView[] numberTextViews;
    private int currentNumberIndex;
    private Handler handler;
    private Runnable numberRunnable;

    private static int score;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rememberfrwd);

        numberTextViews = new TextView[5];
        numberTextViews[0] = findViewById(R.id.number1);
        numberTextViews[1] = findViewById(R.id.number2);
        numberTextViews[2] = findViewById(R.id.number3);
        numberTextViews[3] = findViewById(R.id.number4);
        numberTextViews[4] = findViewById(R.id.number5);

        EditText editText = findViewById(R.id.editText);





        handler = new Handler();
        numberRunnable = new Runnable() {
            @Override
            public void run() {
                hideCurrentNumber();
                showNextNumber();
            }
        };

        Button buttonBack = findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopNumberRunnable();
                Intent intent = new Intent(rememberbckwrd.this, MindTraining.class);
                startActivity(intent);
            }
        });

        Button buttonSubmit = findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userInput = editText.getText().toString();

                String[] inputNumbers = userInput.split(" ");

                if (inputNumbers.length != 5) {
                    Toast.makeText(rememberbckwrd.this, "Please enter five numbers separated by spaces", Toast.LENGTH_SHORT).show();
                    return;
                }




                boolean isCorrect = true;


                for (int i = 0; i < inputNumbers.length; i++) {
                    int inputNumber = Integer.parseInt(inputNumbers[4-i]);
                    int displayedNumber = Integer.parseInt(numberTextViews[i].getText().toString());

                    if (inputNumber != displayedNumber) {
                        isCorrect = false;
                        break;
                    }
                }



                if (isCorrect) {
                    Toast.makeText(rememberbckwrd.this, "Correct!", Toast.LENGTH_SHORT).show();

                    score+=10;
                }
                else {
                    Toast.makeText(rememberbckwrd.this, "Wrong!", Toast.LENGTH_SHORT).show();

                    score-=5;
                }

            }
        });

        // Find the button view
        Button buttonre = findViewById(R.id.button_retry);

// Set an OnClickListener
        buttonre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retry(editText);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        startNumberRunnable();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopNumberRunnable();
    }

    private void startNumberRunnable() {
        currentNumberIndex = 0;
        showNextNumber();
    }

    private void stopNumberRunnable() {
        handler.removeCallbacks(numberRunnable);
    }

    private void showNextNumber() {
        if (currentNumberIndex >= numberTextViews.length) {
            // All numbers have been shown
            return;
        }

        hideAllNumbers();

        TextView currentNumberTextView = numberTextViews[currentNumberIndex];
        currentNumberTextView.setText(String.valueOf(generateRandomNumber()));
        currentNumberTextView.setVisibility(View.VISIBLE);

        currentNumberIndex++;

        handler.postDelayed(numberRunnable, DELAY_MS);
    }

    private void hideCurrentNumber() {
        if (currentNumberIndex - 1 >= 0 && currentNumberIndex - 1 < numberTextViews.length) {
            TextView previousNumberTextView = numberTextViews[currentNumberIndex - 1];
            previousNumberTextView.setVisibility(View.INVISIBLE);
        }
    }

    private void hideAllNumbers() {
        for (TextView numberTextView : numberTextViews) {
            numberTextView.setVisibility(View.INVISIBLE);
        }
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10); // Generates a random number between 0 and 99
    }

    private void retry(EditText editText) {
        editText.setText(""); // Clear the input field

        // Hide all numbers
        hideAllNumbers();

        // Reset currentNumberIndex
        currentNumberIndex = 0;

        // Start showing numbers again
        startNumberRunnable();
    }
}
