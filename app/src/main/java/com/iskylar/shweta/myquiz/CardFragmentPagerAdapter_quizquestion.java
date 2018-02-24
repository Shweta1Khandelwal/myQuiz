package com.iskylar.shweta.myquiz;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.CardView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shweta on 2/19/2018.
 */
public class CardFragmentPagerAdapter_quizquestion extends FragmentStatePagerAdapter implements CardAdapter_quizquetion {

    private List<CardFragment_quizquestion> mFragments;
    private float mBaseElevation;

    public CardFragmentPagerAdapter_quizquestion(FragmentManager fm, float baseElevation) {
        super(fm);
        mFragments = new ArrayList<>();
        mBaseElevation = baseElevation;

        for(int i = 0; i< 5; i++){
            addCardFragment(new CardFragment_quizquestion());
        }
    }

    @Override
    public float getBaseElevation() {
        return mBaseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return mFragments.get(position).getCardView();
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
       // return mFragments.get(position);

        return null;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        mFragments.set(position, (CardFragment_quizquestion) fragment);
        return fragment;
    }

    public void addCardFragment(CardFragment_quizquestion fragment) {
        mFragments.add(fragment);
    }

}
