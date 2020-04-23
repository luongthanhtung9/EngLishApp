package com.example.englishapp.view.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.englishapp.view.fragment.FragmentEnglish;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    int numberPager;

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        FragmentEnglish fragmentEnglish = new FragmentEnglish();
        fragmentEnglish.setArguments(bundle);
        return fragmentEnglish;
    }

    @Override
    public int getCount() {
        return numberPager;
    }

    public void setNumberPager(int numberPager) {
        this.numberPager = numberPager;
    }
}
