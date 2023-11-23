package com.example.ourproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NumbersTraining extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers_training);

        Button buttonback = findViewById(R.id.button_back);

                // Set an OnClickListener
                buttonback.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                       Intent intent = new Intent(NumbersTraining.this, LearningActivity.class);
                    startActivity(intent);
                    }
                });

    }
}