package com.example.englishapp.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;

import com.example.englishapp.R;
import com.example.englishapp.view.adapter.ViewPagerAdapter;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText mInputEditText;
    private TextToSpeech mTextToSpeech;
    private ViewPagerAdapter mAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInputEditText = findViewById(R.id.txt_input);
        mTextToSpeech = new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    mTextToSpeech.setLanguage(Locale.US);
                    //textToSpeech.setLanguage(new Locale(Locale.getDefault().getLanguage()));
                }
            }
        });
        findViewById(R.id.btn_speak).setOnClickListener(this);
        mViewPager = findViewById(R.id.view_pager);
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mAdapter.setNumberPager(5);
        mViewPager.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_speak) {
            String txtInput = mInputEditText.getText().toString();

            if (!txtInput.equals("")) {
                //textToSpeech.setPitch(0.5f);
                mTextToSpeech.setSpeechRate(0.5f);

                if (!mTextToSpeech.isSpeaking()) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        mTextToSpeech.speak(txtInput, TextToSpeech.QUEUE_FLUSH, null, null);
                    } else {
                        mTextToSpeech.speak(txtInput, TextToSpeech.QUEUE_FLUSH, null);
                    }
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        if (mTextToSpeech != null) {
            mTextToSpeech.stop();
            mTextToSpeech.shutdown();
        }
        super.onDestroy();

    }

    @Override
    protected void onPause() {
        if (mTextToSpeech != null) {
            mTextToSpeech.stop();
            mTextToSpeech.shutdown();
        }
        super.onPause();
    }
}
