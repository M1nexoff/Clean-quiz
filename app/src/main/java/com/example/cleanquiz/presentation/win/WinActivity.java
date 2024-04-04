package com.example.cleanquiz.presentation.win;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.cleanquiz.R;
import com.example.cleanquiz.data.model.CategoryEnum;
import com.example.cleanquiz.domain.AppController;

public class WinActivity extends AppCompatActivity implements WinContract.View {

    private SharedPreferences sharedPreferences;
    private AppController appController = AppController.getInstance();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        sharedPreferences = getSharedPreferences("ANSWERS", MODE_PRIVATE);
        int count = getIntent().getIntExtra("COUNT", 0);
        TextView name = findViewById(R.id.text_name);

        TextView correct = findViewById(R.id.correct);
        correct.setText("Correct Answers: " + count);
        TextView wrong = findViewById(R.id.wrong);
        wrong.setText("Wrong Answers: " + (10 - count));
        TextView proncent = findViewById(R.id.percentage);
        proncent.setText("Percentage: " + count * 10 + "%");
        CategoryEnum categoryEnum = AppController.getInstance().getType();
        if (count*10>=60) {
            switch (categoryEnum) {
                case INTRODUCTION:
                    appController.setOpen(CategoryEnum.TYPE);
                    name.setText("Introduction");
                    break;
                case TYPE:
                    appController.setOpen(CategoryEnum.STRING);
                    name.setText("Types");
                    break;
                case STRING:
                    appController.setOpen(CategoryEnum.ARRAY);
                    name.setText("Strings");
                    break;
                case ARRAY:
                    appController.setOpen(CategoryEnum.CLASS);
                    name.setText("Arrays");
                    break;
                case CLASS:
                    ((TextView) findViewById(R.id.finish_text)).setText("You finished app !\nYour result !\nThanks for using !");
                    name.setText("Class and Objects");
                    break;
            }
            ((TextView) findViewById(R.id.finish_text)).setText("You finished test !\nYour result !\nNext level opened !");
        } else {
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
                    ((TextView) findViewById(R.id.finish_text)).setText("You finished test !\nYour result !");
                    name.setText("Class and Objects");
                    break;
            }
        }

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