package com.example.cleanquiz.presentation.win;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.cleanquiz.R;

public class WinActivity extends AppCompatActivity implements WinContract.View{

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        sharedPreferences = getSharedPreferences("ANSWERS",MODE_PRIVATE);
        int count = getIntent().getIntExtra("COUNT",0);
        TextView correct = findViewById(R.id.correct);
        correct.setText("Correct Answers: " + count);
        TextView wrong = findViewById(R.id.wrong);
        wrong.setText("Wrong Answers: " + (10-count));
        TextView proncent = findViewById(R.id.proncent);
        proncent.setText("Percentage: " + count * 10 + "%");
        AppCompatButton back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());
    }
}