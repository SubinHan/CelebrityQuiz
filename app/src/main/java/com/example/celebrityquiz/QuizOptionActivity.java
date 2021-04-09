package com.example.celebrityquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class QuizOptionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_option);

        CardView celebrityCardView = findViewById(R.id.celebrityCardView);
        CardView scienceCardView = findViewById(R.id.scienceCardView);
        CardView animalCardView = findViewById(R.id.animalCardView);

        celebrityCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizOptionActivity.this, MainActivity.class));
            }
        });

        scienceCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizOptionActivity.this, ScienceActivity.class));
            }
        });

        animalCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizOptionActivity.this, AnimalActivity.class ));
            }
        });

    }
}
