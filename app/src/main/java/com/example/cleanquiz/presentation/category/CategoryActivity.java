package com.example.cleanquiz.presentation.category;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cleanquiz.R;
import com.example.cleanquiz.data.model.CategoryEnum;
import com.example.cleanquiz.domain.AppController;
import com.example.cleanquiz.presentation.dialog.DialogListener;
import com.example.cleanquiz.presentation.dialog.QuitAppDialog;
import com.example.cleanquiz.presentation.main.MainActivity;
import com.example.cleanquiz.presentation.records.RecordsActivity;

public class CategoryActivity extends AppCompatActivity implements CategoryContract.View {
    private CategoryContract.Presenter presenter;
    private AppController controller = AppController.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        presenter = new CategoryPresenter(this);
        attachViews();
    }

    private void attachViews() {

        findViewById(R.id.quit).setOnClickListener(v -> {
            startActivity(new Intent(this, RecordsActivity.class));
        });


        int[] buttonIds = {R.id.kotlin, R.id.cpp, R.id.java, R.id.php, R.id.go, R.id.rust, R.id.java_script};
        CategoryEnum[] categories = {CategoryEnum.KOTLIN, CategoryEnum.CPP, CategoryEnum.JAVA, CategoryEnum.PHP, CategoryEnum.GO, CategoryEnum.RUST, CategoryEnum.JAVASCRIPT};

        for (int i = 0; i < buttonIds.length; i++) {
            int buttonId = buttonIds[i];
            CategoryEnum category = categories[i];
            findViewById(buttonId).setOnClickListener(v -> {
                presenter.setSelectCategory(category);
            });
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        attachViews();
    }

    private void exit() {
        QuitAppDialog dialog = new QuitAppDialog(new DialogListener() {
            @Override
            public void onYesClicked() {
                finish();
            }

            @Override
            public void onNoClicked() {

            }
        });
        dialog.show(getSupportFragmentManager(), "QuitDialog");
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
                if (event.getPointerCount() == 3) {
                    return true;
                }
                break;
        }

        return super.onTouchEvent(event);
    }
}