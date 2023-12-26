package com.example.cleanquiz.presentation.category;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.cleanquiz.R;
import com.example.cleanquiz.data.model.CategoryEnum;
import com.example.cleanquiz.presentation.main.MainActivity;

public class CategoryActivity extends AppCompatActivity implements CategoryContract.View{
    private CategoryContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        presenter = new CategoryPresenter(this);
        attachViews();
    }

    private void attachViews() {
        findViewById(R.id.introduction).setOnClickListener(v-> presenter.setSelectCategory(CategoryEnum.INTRODUCTION));
        findViewById(R.id.types).setOnClickListener(v-> presenter.setSelectCategory(CategoryEnum.TYPE));
        findViewById(R.id.strings).setOnClickListener(v-> presenter.setSelectCategory(CategoryEnum.STRING));
        findViewById(R.id.arrays).setOnClickListener(v-> presenter.setSelectCategory(CategoryEnum.ARRAY));
        findViewById(R.id.clas).setOnClickListener(v-> presenter.setSelectCategory(CategoryEnum.CLASS));
        findViewById(R.id.quit).setOnClickListener(v-> exit());
    }

    private void exit() {
        new AlertDialog.Builder(CategoryActivity.this)
                .setMessage("Are you want to exit?")
                .setTitle("Exit?")
                .setPositiveButton("Exit", (dialog, which) -> finish())
                .setNegativeButton("Cancel", (dialog, which) -> {})
                .create().show();
    }

    @Override
    public void openQuestionActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}