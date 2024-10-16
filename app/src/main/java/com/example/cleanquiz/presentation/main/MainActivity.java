package com.example.cleanquiz.presentation.main;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cleanquiz.R;
import com.example.cleanquiz.data.model.QuestionData;
import com.example.cleanquiz.presentation.dialog.DialogListener;
import com.example.cleanquiz.presentation.dialog.QuitAppDialog;
import com.example.cleanquiz.presentation.win.WinActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private MainContract.Presenter presenter;
    private TextView textQuestion;
    private List<ViewGroup> groupsVariant;
    private List<ImageView> images;
    private List<TextView> texts;
    private AppCompatButton btnNext;
    private AppCompatButton btnFinish;
    private ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        loadViews();
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                presenter.finish();
            }

        });
        presenter = new MainPresenter(this);
    }

    private void loadViews() {
        textQuestion = findViewById(R.id.text_question);
        btnNext = findViewById(R.id.btn_next);
        btnBack = findViewById(R.id.back);
        btnFinish = findViewById(R.id.btn_finish);
        images = new ArrayList<>();
        images.add(findViewById(R.id.image_variant_1));
        images.add(findViewById(R.id.image_variant_2));
        images.add(findViewById(R.id.image_variant_3));
        images.add(findViewById(R.id.image_variant_4));

        texts = new ArrayList<>();
        texts.add(findViewById(R.id.text_variant_1));
        texts.add(findViewById(R.id.text_variant_2));
        texts.add(findViewById(R.id.text_variant_3));
        texts.add(findViewById(R.id.text_variant_4));

        groupsVariant = new ArrayList<>();
        groupsVariant.add(findViewById(R.id.container_1));
        groupsVariant.add(findViewById(R.id.container_2));
        groupsVariant.add(findViewById(R.id.container_3));
        groupsVariant.add(findViewById(R.id.container_4));

        for (int i = 0; i < groupsVariant.size(); i++) {
            int index = i;
            groupsVariant.get(i).setOnClickListener(v -> {
                presenter.selectAnswer(index);
            });
        }
        ((ProgressBar)findViewById(R.id.progress)).getProgressDrawable().setColorFilter(
                Color.parseColor("#D9362AED"), android.graphics.PorterDuff.Mode.SRC_IN);
        btnNext.setOnClickListener(v -> {
            presenter.clickNextButton();
            ((ProgressBar)findViewById(R.id.progress)).setProgress(presenter.getPos()*10);
        });

        btnFinish.setOnClickListener(v -> presenter.finish());
        btnBack.setOnClickListener(v -> presenter.finish());
    }

    @Override
    public void describeQuestion(QuestionData data) {
        textQuestion.setText(data.getQuestion());
        for (int i = 0; i < texts.size(); i++) {
            texts.get(i).setText(data.getVariants()[i]);
        }
    }

    @Override
    public void clearOldStates(int position) {
        images.get(position).setImageResource(R.drawable.unchecked);
    }

    @Override
    public void nextButtonState(boolean bool) {
        btnNext.setEnabled(bool);
    }

    @Override
    public void showSelectedIndex(int index) {
        images.get(index).setImageResource(R.drawable.checked);
    }

    @Override
    public void showCount(int currentPos) {
        TextView count = findViewById(R.id.count);
        count.setText(currentPos+"/10");
    }

    @Override
    public void fastFinish(int correctCount,int wrongCount) {
        Intent intent = new Intent(MainActivity.this, WinActivity.class);
        intent.putExtra("CORRECT_COUNT", correctCount);
        intent.putExtra("WRONG_COUNT", wrongCount);
        startActivity(intent);
        finish();
    }

    @Override
    public void finish(int correctCount,int wrongCount) {
        QuitAppDialog dialog = new QuitAppDialog(new DialogListener() {
            @Override
            public void onYesClicked() {
                Intent intent = new Intent(MainActivity.this, WinActivity.class);
                intent.putExtra("CORRECT_COUNT", correctCount);
                intent.putExtra("WRONG_COUNT", wrongCount);

                startActivity(intent);
                finish();
            }

            @Override
            public void onNoClicked() {

            }
        }
        );
        dialog.show(getSupportFragmentManager(), "QuitDialog");

    }
}