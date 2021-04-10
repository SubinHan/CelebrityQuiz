package com.example.celebrityquiz;

import java.io.Serializable;
import java.util.List;

public class GameData implements Serializable {
    public static final int GAMEMODE_NORMAL = 0;
    public static final int GAMEMODE_ENDLESS = 1;

    String userEmail;
    List<Quiz> quizList;
    int leftTime;
    int score;
    int gameMdoe;

    public GameData(){
    }

    public GameData(List<Quiz> quizList, String userEmail){
        this();
        this.quizList = quizList;
    }

    public GameData(String userEmail, List<Quiz> quizList, int leftTime, int score, int gameMdoe){
        this.userEmail = userEmail;
        this.quizList = quizList;
        this.leftTime = leftTime;
        this.score = score;
        this.gameMdoe = gameMdoe;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public int getLeftTime() {
        return this.leftTime;
    }

    public int getScore() {
        return this.score;
    }

    public List<Quiz> getQuizList() {
        return this.quizList;
    }

    public int getGameMdoe() {
        return gameMdoe;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setQuizList(List<Quiz> quizList) {
        this.quizList = quizList;
    }

    public void setLeftTime(int leftTime) {
        this.leftTime = leftTime;
    }

    public void setGameMdoe(int gameMdoe) {
        this.gameMdoe = gameMdoe;
    }
}
