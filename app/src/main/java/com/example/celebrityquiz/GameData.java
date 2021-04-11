package com.example.celebrityquiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GameData implements Serializable {
    public static final int GAMEMODE_NORMAL = 0;
    public static final int GAMEMODE_ENDLESS = 1;

    String userEmail;
    List<Quiz> quizList;
    int seconds;
    int leftTime;
    int score;
    int gameMdoe;
    String date;
    int level;
    String domain;

    public GameData(){
    }

    public GameData(List<Quiz> quizList, String userEmail){
        this();
        this.quizList = quizList;
    }

    public GameData(String userEmail, List<Quiz> quizList, int seconds, int leftTime, int score, int gameMdoe, int level, String domain, String date){
        this.userEmail = userEmail;
        this.quizList = quizList;
        this.seconds = seconds;
        this.leftTime = leftTime;
        this.score = score;
        this.gameMdoe = gameMdoe;
        this.level = level;
        this.domain = domain;
        this.date = date;
    }

    public List<Quiz> getWrongQuizzes(){
        ArrayList<Quiz> wrongQuzizzes = new ArrayList<Quiz>();

        for (Quiz quiz : quizList) {
            if(quiz.correctAnswer != quiz.userAnswer)
                wrongQuzizzes.add(quiz);
        }

        return wrongQuzizzes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public int getSeconds() {
        return seconds;
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

    public int getLevel() {
        return level;
    }

    public String getDomain() {
        return domain;
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

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setLeftTime(int leftTime) {
        this.leftTime = leftTime;
    }

    public void setGameMdoe(int gameMdoe) {
        this.gameMdoe = gameMdoe;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
