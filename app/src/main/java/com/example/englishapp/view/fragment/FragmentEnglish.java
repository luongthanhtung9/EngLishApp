package com.example.englishapp.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishapp.R;
import com.example.englishapp.model.Word;
import com.example.englishapp.presenter.Presenter;
import com.example.englishapp.presenter.ViewPresenter;
import com.example.englishapp.view.adapter.RecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentEnglish extends Fragment implements ViewPresenter {
    View v;
    private RecyclerView mRecyclerView;
    private List<Word> mList;
    private RecycleViewAdapter mAdapter;
    Presenter presenter;
    private int page;

    public FragmentEnglish() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        presenter = new Presenter(this);
//        presenter.getData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_english, container, false);
        mRecyclerView = v.findViewById(R.id.recycler_view);
       presenter = new Presenter(this);
        presenter.getData();
        //mAdapter = new RecycleViewAdapter(getContext(), mList);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       // mRecyclerView.setAdapter(mAdapter);
//        mAdapter.setOnItemClickListener(new RecycleViewAdapter.OnItemClickListener() {
//            @Override
//            public void viewOnclick(int position) {
//                Toast.makeText(getContext(), " " + position, Toast.LENGTH_SHORT).show();
//            }
//        });
        return v;
    }

    @Override
    public void onGetResult(List<Word> words) {
        mAdapter = new RecycleViewAdapter(getContext(), words);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);

        mList = words;
        mAdapter.setOnItemClickListener(new RecycleViewAdapter.OnItemClickListener() {
            @Override
            public void viewOnclick(int position) {
                Toast.makeText(getContext(), " " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
