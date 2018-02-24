package com.iskylar.shweta.myquiz;

import android.content.Intent;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Shweta on 2/21/2018.
 */
public class Adapter_recyclerview_QuizType  extends RecyclerView.Adapter<Adapter_recyclerview_QuizType.DataObjectHolder>  implements TextToSpeech.OnInitListener {
    private ArrayList<Data_cardview_QuizType> mDataset;
    private AppCompatActivity activity;

    public Adapter_recyclerview_QuizType(AppCompatActivity activity, ArrayList<Data_cardview_QuizType> mDataset) {

        this.mDataset = mDataset;
        this.activity = activity;
    }

    @Override
    public Adapter_recyclerview_QuizType.DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewquiztype, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, final int position) {
        holder.imageView.setImageResource(mDataset.get(position).getImage());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Data_cardview_QuizType  data_viewpager_quiz =mDataset.get(position);
                Intent i = new Intent(activity,Detail_timeleftActivity.class);
                i.putExtra("img",data_viewpager_quiz.getImage());
                i.putExtra("pos",position);
                activity.startActivity(i);

            }
        });


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public void onInit(int status) {

    }


    public class DataObjectHolder extends RecyclerView.ViewHolder {


        ImageView imageView;

        public DataObjectHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_card);

        }


    }
}
