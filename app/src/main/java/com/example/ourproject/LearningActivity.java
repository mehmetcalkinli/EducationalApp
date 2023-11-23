package com.example.ourproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.view.View;



public class LearningActivity extends AppCompatActivity {

    //private static final android.R.attr R = ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learning);





        // Find the button view
        Button button2 = findViewById(R.id.button_directions);

        // Set an OnClickListener
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(LearningActivity.this, DirectionsTraining.class);
            startActivity(intent);
            }
        });

         // Find the button view
                Button buttonnum = findViewById(R.id.button_numbers);

                // Set an OnClickListener
                buttonnum.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Intent intent = new Intent(LearningActivity.this, NumbersTraining.class);
                    startActivity(intent);
                    }
                });


// Find the button view
Button button3 = findViewById(R.id.button_seasons);

// Set an OnClickListener
button3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       Intent intent = new Intent(LearningActivity.this, SeasonsTraining.class);
    startActivity(intent);
    }
});


// Find the button view
Button button4 = findViewById(R.id.button_months);

// Set an OnClickListener
button4.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       Intent intent = new Intent(LearningActivity.this, MonthsTraining.class);
    startActivity(intent);
    }
});


// Find the button view
Button button5 = findViewById(R.id.button_Days);

// Set an OnClickListener
button5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       Intent intent = new Intent(LearningActivity.this, DaysTraining.class);
    startActivity(intent);
    }
});




// Find the button view
Button button8 = findViewById(R.id.button_multiplication);

// Set an OnClickListener
button8.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       Intent intent = new Intent(LearningActivity.this, MultipllicationTraining.class);
    startActivity(intent);
    }
});

// Find the button view
Button button9 = findViewById(R.id.button_clock);

// Set an OnClickListener
button9.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       Intent intent = new Intent(LearningActivity.this, ClockTraining.class);
    startActivity(intent);
    }
});
// Find the button view
        Button buttonback = findViewById(R.id.button_back);

// Set an OnClickListener
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearningActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }
}