package com.example.cleanquiz.presentation.category;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.cleanquiz.R;
import com.example.cleanquiz.data.model.CategoryEnum;
import com.example.cleanquiz.domain.AppController;
import com.example.cleanquiz.presentation.main.MainActivity;
import com.google.android.material.snackbar.Snackbar;

public class CategoryActivity extends AppCompatActivity implements CategoryContract.View{
    private CategoryContract.Presenter presenter;
    private AppController controller =  AppController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        presenter = new CategoryPresenter(this);
        attachViews();
    }

    private void attachViews() {
        findViewById(R.id.introduction).setOnClickListener(v-> {
            presenter.setSelectCategory(CategoryEnum.INTRODUCTION);
        });
        findViewById(R.id.quit).setOnClickListener(v-> exit());


        int[] buttonIds = {R.id.introduction,R.id.types,R.id.strings, R.id.arrays, R.id.clas};
        CategoryEnum[] categories = {CategoryEnum.INTRODUCTION,CategoryEnum.TYPE,CategoryEnum.STRING, CategoryEnum.ARRAY, CategoryEnum.CLASS};

        for (int i = 1; i < buttonIds.length; i++) {
            int buttonId = buttonIds[i];
            CategoryEnum category = categories[i];
            if (controller.isOpen(category)) {
                    FrameLayout frame = (FrameLayout)((CardView)((LinearLayout) findViewById(R.id.container)).getChildAt(i)).getChildAt(0);
                    frame.getChildAt(0).setVisibility(View.VISIBLE);
                    frame.getChildAt(1).setVisibility(View.INVISIBLE);
                findViewById(buttonId).setOnClickListener(v -> {
                    presenter.setSelectCategory(category);
                });

            } else {
                findViewById(buttonId).setOnClickListener(v -> {
                    Snackbar.make(this, findViewById(android.R.id.content), "Done previous test with more than 60% to access this test!", Snackbar.LENGTH_SHORT).show();
                });
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        attachViews();
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
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int action = event.getActionMasked();

        switch (action) {
            case MotionEvent.ACTION_POINTER_DOWN:
                // Check if it's a three-finger touch
                if (event.getPointerCount() == 3) {
                    // Consume the event to prevent further processing
                    return true;
                }
                break;
        }

        // Let the system handle the event for other cases
        return super.onTouchEvent(event);
    }
}