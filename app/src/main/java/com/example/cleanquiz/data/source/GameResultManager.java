package com.example.cleanquiz.data.source;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.cleanquiz.data.model.GameResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResultManager {
    private static final String PREFERENCES_FILE = "game_results";
    private static final String KEY_TOP_10 = "top_10";

    private SharedPreferences sharedPreferences;
    private static GameResultManager gameResultManager;

    private GameResultManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE);
    }

    public static void init(Context context){
        gameResultManager = new GameResultManager(context);
    }
    public static GameResultManager getInstance(){
        return gameResultManager;
    }

    public void saveTop10Results(List<GameResult> top10Results) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        StringBuilder sb = new StringBuilder();
        for (GameResult result : top10Results) {
            sb.append(result.toString()).append(";");
        }
        editor.putString(KEY_TOP_10, sb.toString());
        editor.apply();
    }

    public List<GameResult> getTop10Results() {
        String savedString = sharedPreferences.getString(KEY_TOP_10, "");
        List<GameResult> top10Results = new ArrayList<>();
        if (!savedString.isEmpty()) {
            String[] resultStrings = savedString.split(";");
            for (String resultString : resultStrings) {
                top10Results.add(GameResult.fromString(resultString));
            }
        }
        return top10Results;
    }

    public void updateTop10Results(GameResult newResult) {
        List<GameResult> top10Results = getTop10Results();
        if (top10Results.size() < 10) {
            top10Results.add(newResult);
        } else {
            Collections.sort(top10Results);
            if (newResult.compareTo(top10Results.get(0)) > 0) {
                top10Results.set(0, newResult);
            }
        }
        Collections.sort(top10Results, Collections.reverseOrder());
        saveTop10Results(top10Results);
    }
}
