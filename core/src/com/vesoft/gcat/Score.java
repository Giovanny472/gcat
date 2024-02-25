package com.vesoft.gcat;

public class Score {

    private int scoreCounter;
    private  final String scoreCaption = "Score: ";

    public Score() {
        scoreCounter = 0;
    }

    public int GetCounter() {
        return scoreCounter;
    }

    public void Increment() {
        scoreCounter++;
    }

    public String GetScoreStr() {
        return scoreCaption + scoreCounter;
    }
}
