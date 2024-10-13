package com.example.cleanquiz.presentation.records;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cleanquiz.R;
import com.example.cleanquiz.data.model.GameResult;
import com.example.cleanquiz.data.source.GameResultManager;
import com.example.cleanquiz.domain.AppController;
import com.example.cleanquiz.presentation.GameResultAdapter;
import com.example.cleanquiz.presentation.dialog.DeleteRecordDialog;
import com.example.cleanquiz.presentation.dialog.DialogListener;

import java.util.ArrayList;
import java.util.List;

public class RecordsActivity extends AppCompatActivity implements RecordContract.View {
    private RecyclerView recyclerView;
    private GameResultAdapter adapter;
    private GameResultManager gameResultManager;
    private ImageView placeHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        gameResultManager = GameResultManager.getInstance();
        GameResultManager gameResultManager = GameResultManager.getInstance();
        List<GameResult> date = gameResultManager.getTop10Results();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<GameResult> top10Results = gameResultManager.getTop10Results();
        placeHolder= findViewById(R.id.place_holder);
        if (top10Results.isEmpty()){
            placeHolder.setVisibility(View.VISIBLE);
        }else {
            placeHolder.setVisibility(View.INVISIBLE);
        }
        adapter = new GameResultAdapter(top10Results);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.quit_record).setOnClickListener(v->finish());
        findViewById(R.id.delete).setOnClickListener(v->setNull());

    }
    void setNull(){
        DeleteRecordDialog dialog = new DeleteRecordDialog(new DialogListener() {
            @Override
            public void onYesClicked() {
                gameResultManager.saveTop10Results(new ArrayList<GameResult>());
                List<GameResult> list = gameResultManager.getTop10Results();
                if (list.isEmpty()){
                    placeHolder.setVisibility(View.VISIBLE);
                }else {
                    placeHolder.setVisibility(View.INVISIBLE);
                }
                adapter.gameResults = list;
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNoClicked() {
            }
        });
        dialog.show(getSupportFragmentManager(),"");

    }
}