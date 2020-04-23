package com.example.englishapp.presenter;

import com.example.englishapp.model.Word;

import java.util.List;

public interface ViewPresenter {
    void onGetResult(List<Word> notes);
}
