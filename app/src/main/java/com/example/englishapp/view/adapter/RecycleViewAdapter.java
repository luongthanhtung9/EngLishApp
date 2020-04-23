package com.example.englishapp.view.adapter;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishapp.R;
import com.example.englishapp.model.Word;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    Context mContext;
    List<Word> mListWord;

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public RecycleViewAdapter(Context mContext, List<Word> mListWord ) {
        this.mContext = mContext;
        this.mListWord = mListWord;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_english, parent, false);
        return new ViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Word word = mListWord.get(position);
        holder.txtWord.setText(word.getWordEngLish());
        holder.imageSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.viewOnclick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListWord.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtWord;
        ImageView imageSpeak;
        OnItemClickListener itemClickListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            this.itemClickListener = onItemClickListener;
            txtWord = itemView.findViewById(R.id.txt_english_word);
            imageSpeak = itemView.findViewById(R.id.img_speak);

        }

    }


    public interface OnItemClickListener {
        void viewOnclick(int position);

    }
}
