package com.example.cleanquiz.presentation.win;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.example.cleanquiz.R;
import com.example.cleanquiz.data.model.CategoryEnum;
import com.example.cleanquiz.data.model.GameResult;
import com.example.cleanquiz.data.source.GameResultManager;
import com.example.cleanquiz.domain.AppController;
import com.example.cleanquiz.presentation.dialog.SaveResultDialog;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

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
        int count = getIntent().getIntExtra("CORRECT_COUNT", 0);
        int wrong_ans = getIntent().getIntExtra("WRONG_COUNT", 0);
        TextView name = findViewById(R.id.text_name);
        int skipped = 10-wrong_ans-count;


        PieChart chart = findViewById(R.id.chart1);
        ArrayList<PieEntry> entries = new ArrayList<>();
        ArrayList<Integer>  colors = new ArrayList<>();

        if (wrong_ans>0) {
            entries.add(new PieEntry(wrong_ans, "Wrong"));
            colors.add(Color.RED);
        }
        if (count>0){
            entries.add(new PieEntry(count, "Correct"));
            colors.add(Color.GREEN);
        }
        if (skipped>0){
            entries.add(new PieEntry(skipped, "Skipped"));
            colors.add(Color.parseColor("#FFA500"));
        }

        PieDataSet dataSet = new PieDataSet(entries,"");



        PieData data = new PieData(dataSet);

        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(23f);
        data.setValueTextColor(Color.WHITE);




        chart.setData(data);
        chart.setCenterTextColor(Color.WHITE);

        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors (colors);




        chart.setUsePercentValues(true);
        chart.getDescription().setEnabled(false);
        chart.setExtraOffsets(5,10,5,5);
        chart.setDragDecelerationFrictionCoef(0.99f);
        chart.setDrawHoleEnabled(true);
        chart.setHoleColor(Color.parseColor("#DCB3EC"));
        chart.setTransparentCircleRadius(61f);
        chart.setDescription(null);



        TextView correct = findViewById(R.id.correct);
        correct.setText("Correct Answers: " + count);
        TextView wrong = findViewById(R.id.wrong);
        wrong.setText("Wrong Answers: " + (10 - count));
        TextView proncent = findViewById(R.id.percentage);
        proncent.setText("Percentage: " + count * 10 + "%");
        CategoryEnum categoryEnum = AppController.getInstance().getType();
        int temp = 0;
        switch (categoryEnum) {
            case KOTLIN:
                name.setText("Kotlin");
                break;
            case CPP:
                temp = 1;
                name.setText("C++");
                break;
            case JAVA:
                temp = 2;
                name.setText("Java");
                break;
            case PHP:
                temp = 3;
                name.setText("PHP");
                break;
            case GO:
                temp = 4;
                name.setText("Go");
                break;
            case RUST:
                temp = 5;
                name.setText("Rust");
                break;
            case JAVASCRIPT:
                temp = 6;
                name.setText("Java Script");
                break;
        }
        int finalTemp = temp;
        findViewById(R.id.save2).setOnClickListener((v)->{
            SaveResultDialog saveResultDialog = new SaveResultDialog((s)->{
                saveResult(v,new GameResult(count,wrong_ans,skipped,finalTemp,s));
            });
            saveResultDialog.show(getSupportFragmentManager(),null);
        });
        AppCompatButton back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());
    }
    private void saveResult(View v, GameResult gm){
        GameResultManager.getInstance().updateTop10Results(gm);
        v.setVisibility(View.INVISIBLE);
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
