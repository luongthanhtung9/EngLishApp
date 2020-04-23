package com.example.englishapp.presenter;

import com.example.englishapp.model.Word;

import java.util.ArrayList;
import java.util.List;

public class Presenter {
    ViewPresenter viewPresenter;

    public Presenter(ViewPresenter viewPresenter) {
        this.viewPresenter = viewPresenter;
    }


    public void getData() {
        List<Word> words = new ArrayList<>();
        words.add(new Word(1, "hello"));
        words.add(new Word(1, "hello"));
        words.add(new Word(1, "hello"));
        words.add(new Word(1, "hello"));
        viewPresenter.onGetResult(words);
    }
}
