package com.iskylar.shweta.myquiz;

import android.support.v7.widget.CardView;

/**
 * Created by Shweta on 2/19/2018.
 */
public interface CardAdapter_quizquetion {

    int MAX_ELEVATION_FACTOR = 8;

    float getBaseElevation();

    CardView getCardViewAt(int position);

    int getCount();
}
