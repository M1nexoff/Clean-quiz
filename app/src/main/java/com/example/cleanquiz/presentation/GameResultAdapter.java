package com.example.cleanquiz.presentation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cleanquiz.R;
import com.example.cleanquiz.data.model.GameResult;

import java.util.List;

public class GameResultAdapter extends RecyclerView.Adapter<GameResultAdapter.GameResultViewHolder> {
    public List<GameResult> gameResults;

    public GameResultAdapter(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    @NonNull
    @Override
    public GameResultViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        return new GameResultViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameResultViewHolder holder, int position) {

        GameResult gameResult = gameResults.get(position);
        holder.textPlayerName.setText(gameResult.getName());
        holder.textCorrect.setText("Correct: " + gameResult.getCorrect());
        holder.textWrong.setText("Wrong: " + gameResult.getWrong());
        holder.textSkipped.setText("Skipped: " + gameResult.getSkipped());
        switch (gameResult.getCategory()) {
            case 0:
                holder.category.setText("Category: Kotlin");
                break;
            case 1:
                holder.category.setText("Category: C++");
                break;
            case 2:
                holder.category.setText("Category: Java");
                break;
            case 3:
                holder.category.setText("Category: PHP");
                break;
            case 4:
                holder.category.setText("Category: Go");
                break;
            case 5:
                holder.category.setText("Category: Rust");
                break;
            case 6:
                holder.category.setText("Category: Java Script");
                break;
        }


    }

    @Override
    public int getItemCount() {
        return gameResults.size();
    }

    public static class GameResultViewHolder extends RecyclerView.ViewHolder {
        TextView textPlayerName;
        TextView textCorrect;
        TextView textWrong;
        TextView textSkipped;
        TextView category;

        public GameResultViewHolder(@NonNull View itemView) {
            super(itemView);
            textPlayerName = itemView.findViewById(R.id.player_name);
            textCorrect = itemView.findViewById(R.id.correct);
            textWrong = itemView.findViewById(R.id.wrong);
            textSkipped = itemView.findViewById(R.id.skipped);
            category = itemView.findViewById(R.id.category);
        }
    }
}

