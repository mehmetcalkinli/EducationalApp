package com.example.ourproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PlayingActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing);


        // Find the button view
        Button buttonball = findViewById(R.id.button_ball);

// Set an OnClickListener
        buttonball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open a new screen or activity here

                Intent intent = new Intent(PlayingActivity.this, BallActivity.class);
                startActivity(intent);

            }
        });


        // Find the button view
        Button buttonpic = findViewById(R.id.button_similarpic);

        // Set an OnClickListener
        buttonpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open a new screen or activity here

                Intent intent = new Intent(PlayingActivity.this, SimilarPictures.class);
                startActivity(intent);

            }
        });


        // Find the button view
        Button buttonback = findViewById(R.id.button_back);

        // Set an OnClickListener
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open a new screen or activity here

                Intent intent = new Intent(PlayingActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


// Find the button view
        Button button6 = findViewById(R.id.button_mind);

// Set an OnClickListener
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayingActivity.this, MindTraining.class);
                startActivity(intent);
            }
        });


// Find the button view
        Button button7 = findViewById(R.id.button_word);

// Set an OnClickListener
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PlayingActivity.this, WordTraining.class);
                startActivity(intent);
            }
        });


    }
}