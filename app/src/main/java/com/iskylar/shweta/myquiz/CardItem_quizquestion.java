package com.iskylar.shweta.myquiz;

/**
 * Created by Shweta on 2/19/2018.
 */
public class CardItem_quizquestion {

    private int mTextResource;
    private int mTitleResource;

    public CardItem_quizquestion(int title, int text) {
        mTitleResource = title;
        mTextResource = text;
    }

    public int getText() {
        return mTextResource;
    }

    public int getTitle() {
        return mTitleResource;
    }
}