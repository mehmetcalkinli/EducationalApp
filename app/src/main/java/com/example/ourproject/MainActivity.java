package com.example.ourproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ourproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private TextView tvAssistant;
    private EditText etUserInput;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        tvAssistant = findViewById(R.id.tvAssistant);
        etUserInput = findViewById(R.id.etUserInput);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Find the button view
        Button buttonlrn = findViewById(R.id.button_learning);

// Set an OnClickListener
        buttonlrn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open a new screen or activity here

                Intent intent = new Intent(MainActivity.this, LearningActivity.class);
                startActivity(intent);

            }
        });


        // Find the button view
        Button buttonply = findViewById(R.id.button_playing);

// Set an OnClickListener
        buttonply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlayingActivity.class);
                startActivity(intent);
            }
        });


        Button buttonask = findViewById(R.id.btnAsk);

// Set an OnClickListener
        buttonask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askClicked();

            }
        });

    }



        public void askClicked() {
            String userQuery = etUserInput.getText().toString();
            // Call your virtual assistant function or API to process the user query
            // and get the assistant's response
            String assistantResponse = getAssistantResponse(userQuery);
            tvAssistant.setText(assistantResponse);
        }

    private String getAssistantResponse(String userQuery) {


        /* if (userQuery.equalsIgnoreCase("Hello")) {
            return "Hello! How can I assist you?";
        }
         else if (userQuery.equalsIgnoreCase("Game")) {

                            return "What do you want to play today?";
}

          else if (userQuery.equalsIgnoreCase("Teach me.")) {

                                                return "Good luck.";
          }


        else if (userQuery.equalsIgnoreCase("Learn")) {
            Intent intent = new Intent(MainActivity.this, LearningActivity.class);
            startActivity(intent);

            return "What do you want to learn?";
        }
            else if (userQuery.equalsIgnoreCase("Play")) {
                Intent intent = new Intent(MainActivity.this, PlayingActivity.class);
                startActivity(intent);

                return "Good luck.";

        }

        else if (userQuery.equalsIgnoreCase("Game")) {
                    Intent intent = new Intent(MainActivity.this, LearningActivity.class);
                    startActivity(intent);

                    return "Good luck.";
                    }


                    else if (userQuery.equalsIgnoreCase("Play")) {
                Intent intent = new Intent(MainActivity.this, PlayingActivity.class);
                startActivity(intent);

                return "Good luck.";

        }
            else if (userQuery.equalsIgnoreCase("Seasons")) {
                Intent intent = new Intent(MainActivity.this, SeasonsTraining.class);
                startActivity(intent);

                return "Good luck.";

        }                   else if (userQuery.equalsIgnoreCase("Days")) {
                Intent intent = new Intent(MainActivity.this, DaysTraining.class);
                startActivity(intent);

                return "Good luck.";

        }              else if (userQuery.equalsIgnoreCase("Clock")) {
                Intent intent = new Intent(MainActivity.this, ClockTraining.class);
                startActivity(intent);

                return "Good luck.";

        }
            else if (userQuery.equalsIgnoreCase("Months")) {
                Intent intent = new Intent(MainActivity.this, MonthsTraining.class);
                startActivity(intent);

                return "Good luck.";

        }
            else if (userQuery.equalsIgnoreCase("Multiplication")) {
                Intent intent = new Intent(MainActivity.this, MultipllicationTraining.class);
                startActivity(intent);

                return "Good luck.";

        }
            else if (userQuery.equalsIgnoreCase("Months")) {
                Intent intent = new Intent(MainActivity.this, MonthsTraining.class);
                startActivity(intent);

                return "Good luck.";

        }
                    else if (userQuery.equalsIgnoreCase("Directions")) {
                        Intent intent = new Intent(MainActivity.this, DirectionsTraining.class);
                        startActivity(intent);

                        return "Good luck.";

                }
                else if (userQuery.equalsIgnoreCase("Numbers")) {
                                        Intent intent = new Intent(MainActivity.this, NumbersTraining.class);
                                        startActivity(intent);

                                        return "Good luck.";

                                }
        else {
            return "I'm sorry, I didn't understand your query.";
        } */

        switch (userQuery.toLowerCase()) {
            case "hello":
                return "Hello! How can I help you?";
            case "game":
                return "What do you want to play today?";
            case "teach me.":
                return "What do you want to learn today?.";
            case "learn":
                Intent learnIntent = new Intent(MainActivity.this, LearningActivity.class);
                startActivity(learnIntent);
                return "Good luck!";
            case "play":
                Intent playIntent = new Intent(MainActivity.this, PlayingActivity.class);
                startActivity(playIntent);
                return "Good luck.";
            case "seasons":
                Intent seasonsIntent = new Intent(MainActivity.this, SeasonsTraining.class);
                startActivity(seasonsIntent);
                return "Good luck.";
            case "days":
                Intent daysIntent = new Intent(MainActivity.this, DaysTraining.class);
                startActivity(daysIntent);
                return "Good luck.";
            case "clock":
                Intent clockIntent = new Intent(MainActivity.this, ClockTraining.class);
                startActivity(clockIntent);
                return "Good luck.";
            case "months":
                Intent monthsIntent = new Intent(MainActivity.this, MonthsTraining.class);
                startActivity(monthsIntent);
                return "Good luck.";
            case "multiplication":
                Intent multiplicationIntent = new Intent(MainActivity.this, MultipllicationTraining.class);
                startActivity(multiplicationIntent);
                return "Good luck.";
            case "directions":
                Intent directionsIntent = new Intent(MainActivity.this, DirectionsTraining.class);
                startActivity(directionsIntent);
                return "Good luck.";
            case "numbers":
                Intent numbersIntent = new Intent(MainActivity.this, NumbersTraining.class);
                startActivity(numbersIntent);
                return "Good luck.";
            case "mind":
                Intent mindIntent = new Intent(MainActivity.this, MindTraining.class);
                startActivity(mindIntent);
                return "Good luck.";
            case "ball":
                Intent ballIntent = new Intent(MainActivity.this, BallActivity.class);
                startActivity(ballIntent);
                return "Good luck.";
            case "picture":
                Intent pictureIntent = new Intent(MainActivity.this, SimilarPictures.class);
                startActivity(pictureIntent);
                return "Good luck.";
            case "word":
                Intent wordIntent = new Intent(MainActivity.this, WordTraining.class);
                startActivity(wordIntent);
                return "Good luck.";



                case "merhaba":
                    return "Merhaba nasıl yardımcı olabilirim?";
                case "oyun":
                    return "Bugün ne oynamak istersin?";
                case "bana öğret.":
                    return "Bugün ne öğrenmek istersin";
                case "eğitim":
                    Intent learIntent = new Intent(MainActivity.this, LearningActivity.class);
                    startActivity(learIntent);
                    return "İyi şanslar!";
                case "oynamak":
                    Intent plaIntent = new Intent(MainActivity.this, PlayingActivity.class);
                    startActivity(plaIntent);
                    return "İyi şanslar!";
                case "mevsim":
                    Intent seasonIntent = new Intent(MainActivity.this, SeasonsTraining.class);
                    startActivity(seasonIntent);
                    return "İyi şanslar!";
                case "gün":
                    Intent dayIntent = new Intent(MainActivity.this, DaysTraining.class);
                    startActivity(dayIntent);
                    return "İyi şanslar!";
                case "saat":
                    Intent clocIntent = new Intent(MainActivity.this, ClockTraining.class);
                    startActivity(clocIntent);
                    return "İyi şanslar!";
                case "ay":
                    Intent monthIntent = new Intent(MainActivity.this, MonthsTraining.class);
                    startActivity(monthIntent);
                    return "İyi şanslar!";
                case "çarpma":
                    Intent multiplicatioIntent = new Intent(MainActivity.this, MultipllicationTraining.class);
                    startActivity(multiplicatioIntent);
                    return "İyi şanslar!";
                case "yön":
                    Intent directionIntent = new Intent(MainActivity.this, DirectionsTraining.class);
                    startActivity(directionIntent);
                    return "İyi şanslar!";
                case "sayı":
                    Intent numberIntent = new Intent(MainActivity.this, NumbersTraining.class);
                    startActivity(numberIntent);
                    return "İyi şanslar!";
                case "hafıza":
                    Intent minIntent = new Intent(MainActivity.this, MindTraining.class);
                    startActivity(minIntent);
                    return "İyi şanslar!";
                case "top":
                    Intent balIntent = new Intent(MainActivity.this, BallActivity.class);
                    startActivity(balIntent);
                    return "İyi şanslar!";
                case "resim":
                    Intent picturIntent = new Intent(MainActivity.this, SimilarPictures.class);
                    startActivity(picturIntent);
                    return "İyi şanslar!";
                case "kelime":
                    Intent worIntent = new Intent(MainActivity.this, WordTraining.class);
                    startActivity(worIntent);
                    return "İyi şanslar!";


                default:

                    return "I'm sorry, I didn't understand your query.";
            }

        }


}