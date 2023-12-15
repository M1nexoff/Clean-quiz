package com.example.cleanquiz.presentation.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cleanquiz.R;
import com.example.cleanquiz.data.model.QuestionData;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadViews();
        presenter = new MainPresenter(this);
    }

    private void loadViews() {
        textQuestion = findViewById(R.id.text_question);
        btnNext = findViewById(R.id.btn_next);
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

        btnNext.setOnClickListener(v -> presenter.clickNextButton());
        btnFinish.setOnClickListener(v -> presenter.finish());
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
    public void finish(int correctCount) {
        Intent intent = new Intent(MainActivity.this, WinActivity.class);
        intent.putExtra("COUNT", correctCount);
        startActivity(intent);
        finish();
    }
}