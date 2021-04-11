package com.example.celebrityquiz;

import java.io.Serializable;

public class QuizInfo implements Serializable {

    public static String DOMAIN_ANIMAL = "Animal";
    public static String DOMAIN_CELEBRITY = "Celebrity";
    public static String DOMAIN_SCIENCE = "Science";

    private static String domain;

    public QuizInfo(){


    }

    public static String getDomain() {
        return domain;
    }
}
