package com.example.ourproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MindTraining extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mind_training);

        Button buttonback = findViewById(R.id.button_back);

                // Set an OnClickListener
                buttonback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       Intent intent = new Intent(MindTraining.this, PlayingActivity.class);
                    startActivity(intent);
                    }
                });
                
        Button buttonforw = findViewById(R.id.button_forward);
        
                        // Set an OnClickListener
                        buttonforw.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                               Intent intent = new Intent(MindTraining.this, rememberfrwd.class);
                            startActivity(intent);
                            }
                        });    
        
        
        
        Button buttonbackward = findViewById(R.id.button_backward);
        
                        // Set an OnClickListener
                        buttonbackward.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                               Intent intent = new Intent(MindTraining.this, rememberbckwrd.class);
                            startActivity(intent);
                            }
                        });                    
                




                

    }
}