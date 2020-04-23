package com.example.englishapp.model;

public class Word {
    int id;
    String wordEngLish;

    public int getId() {
        return id;
    }

    public String getWordEngLish() {
        return wordEngLish;
    }

    public Word(int id, String wordEngLish) {
        this.id = id;
        this.wordEngLish = wordEngLish;
    }
}
