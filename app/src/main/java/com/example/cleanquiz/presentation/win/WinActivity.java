package com.example.cleanquiz.presentation.win;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.cleanquiz.R;
import com.example.cleanquiz.data.model.CategoryEnum;
import com.example.cleanquiz.domain.AppController;

public class WinActivity extends AppCompatActivity implements WinContract.View{

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sharedPreferences = getSharedPreferences("ANSWERS",MODE_PRIVATE);
        int count = getIntent().getIntExtra("COUNT",0);
        TextView name = findViewById(R.id.text_name);
        CategoryEnum categoryEnum = AppController.getInstance().getType();
        switch (categoryEnum) {
            case INTRODUCTION:
                name.setText("Introduction");
                break;
            case TYPE:
                name.setText("Types");
                break;
            case STRING:
                name.setText("Strings");
                break;
            case ARRAY:
                name.setText("Arrays");
                break;
            case CLASS:
                name.setText("Class and Objects");
                break;
        }

        TextView correct = findViewById(R.id.correct);
        correct.setText("Correct Answers: " + count);
        TextView wrong = findViewById(R.id.wrong);
        wrong.setText("Wrong Answers: " + (10-count));
        TextView proncent = findViewById(R.id.percentage);
        proncent.setText("Percentage: " + count * 10 + "%");
        AppCompatButton back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getActionMasked();

        switch (action) {
            case MotionEvent.ACTION_POINTER_DOWN:
                if (event.getPointerCount() == 3) {
                    return true;
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}