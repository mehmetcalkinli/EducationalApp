package com.example.ourproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordTraining extends AppCompatActivity implements View.OnClickListener {

    private TextView textMeaning;
    private EditText editTextAnswer;
    private Button buttonSubmit;
    private Button buttonBack;
    private List<WordQuestion> wordQuestions;
    private int currentQuestionIndex;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_training);

        textMeaning = findViewById(R.id.textMeaning);
        editTextAnswer = findViewById(R.id.editTextAnswer);
        buttonSubmit = findViewById(R.id.button_submit);
        buttonBack = findViewById(R.id.button_back);

        buttonSubmit.setOnClickListener(this);
        buttonBack.setOnClickListener(this);

        score = 0;
        wordQuestions = new ArrayList<>();
        initializeWordQuestions();
        currentQuestionIndex = 0;
        showNextQuestion();
    }

    private void checkAnswer(String answer) {
        WordQuestion question = wordQuestions.get(currentQuestionIndex);
        if (answer.equalsIgnoreCase(question.getAnswer())) {
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
            score += 10;
        } else {
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show();
            score -= 3;
        }
        currentQuestionIndex++;
        showNextQuestion();
    }

    private void showNextQuestion() {
        if (currentQuestionIndex < wordQuestions.size()) {
            WordQuestion question = wordQuestions.get(currentQuestionIndex);
            textMeaning.setText(question.getQuestion());
            editTextAnswer.setText("");
        } else {
            textMeaning.setText("Congratulations! You completed the game.(Tebirkler!)\nYour Score(Skorunuz): " + score);
            editTextAnswer.setVisibility(View.GONE);
            buttonSubmit.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_submit) {
            String answer = editTextAnswer.getText().toString().trim();
            if (!answer.isEmpty()) {
                checkAnswer(answer);
            } else {
                Toast.makeText(this, "Please enter your answer(Cevabınızı giriniz)", Toast.LENGTH_SHORT).show();
            }
        } else if (v.getId() == R.id.button_back) {
            onBackPressed();
        }
    }

    private void initializeWordQuestions() {
        wordQuestions.add(new WordQuestion("What is the Capital of Türkiye?(Türkiye'nin başkenti?)", "Ankara"));
        wordQuestions.add(new WordQuestion("What is the biggest mammal?(En büyük memeli canlı?)", "Whale"));
        wordQuestions.add(new WordQuestion("Who painted the Mona Lisa?(Mona Lisa kimi eseri?)", "Leonardo da Vinci"));
        wordQuestions.add(new WordQuestion("Which planet is known as the Red Planet?(Kırmızı gezegen?)", "Mars"));
        wordQuestions.add(new WordQuestion("What is the tallest mountain in the world?(En yüksek dağ?)", "Everest"));
    }

    private static class WordQuestion {
        private String question;
        private String answer;

        public WordQuestion(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer() {
            return answer;
        }
    }
}
