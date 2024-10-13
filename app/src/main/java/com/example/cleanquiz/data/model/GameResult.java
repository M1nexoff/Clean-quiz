package com.example.cleanquiz.data.model;
public class GameResult implements Comparable<GameResult> {
    private int correct;
    private int wrong;
    private int skipped;
    private int category;
    private String name;

    public int getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public GameResult(int correct, int wrong, int skipped, int category) {
        this.category = category;
        this.correct = correct;
        this.wrong = wrong;
        this.skipped = skipped;
        name = "Anonymous";
    }

    public GameResult(int correct, int wrong, int skipped,int category, String name) {
        this.correct = correct;
        this.category = category;
        this.wrong = wrong;
        this.skipped = skipped;
        this.name = name;
    }

    public int getCorrect() {
        return correct;
    }

    public int getWrong() {
        return wrong;
    }

    public int getSkipped() {
        return skipped;
    }

    public int getScore() {
        return correct * 2 - wrong - skipped;
    }

    @Override
    public int compareTo(GameResult other) {
        return Integer.compare(this.getScore(), other.getScore());
    }

    @Override
    public String toString() {
        return correct + "," + wrong + "," + skipped + "," +category + "," + name;
    }

    public static GameResult fromString(String str) {
        String[] parts = str.split(",");
        return new GameResult(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),parts[4]);
    }
}
