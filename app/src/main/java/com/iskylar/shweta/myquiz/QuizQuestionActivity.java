package com.iskylar.shweta.myquiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;

public class QuizQuestionActivity extends AppCompatActivity implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {
    private Button mButton;

    private ViewPager mViewPager;

    private CardPagerAdapter_quizquestion mCardAdapter;
    private ShadowTransformer_quizquestion mCardShadowTransformer;
    private CardFragmentPagerAdapter_quizquestion mFragmentCardAdapter;
    private ShadowTransformer_quizquestion mFragmentCardShadowTransformer;

    private boolean mShowingFragments = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
       /* mButton = (Button) findViewById(R.id.cardTypeBtn);
        ((CheckBox) findViewById(R.id.checkBox)).setOnCheckedChangeListener(this);
        mButton.setOnClickListener(this);*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_quizQuestion);

        toolbar.setTitle("QUIZ");
        setSupportActionBar(toolbar);
        mCardAdapter = new CardPagerAdapter_quizquestion();
        mCardAdapter.addCardItem(new CardItem_quizquestion(R.string.q1, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem_quizquestion(R.string.q2, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem_quizquestion(R.string.q3, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem_quizquestion(R.string.q4, R.string.text_1));
        mFragmentCardAdapter = new CardFragmentPagerAdapter_quizquestion(getSupportFragmentManager(),
                dpToPixels(2, this));

        mCardShadowTransformer = new ShadowTransformer_quizquestion(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer_quizquestion(mViewPager, mFragmentCardAdapter);

        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        mCardShadowTransformer.enableScaling(b);
        mFragmentCardShadowTransformer.enableScaling(b);
    }

    @Override
    public void onClick(View view) {
        if (!mShowingFragments) {
        mButton.setText("Views");
        mViewPager.setAdapter(mFragmentCardAdapter);
        mViewPager.setPageTransformer(false, mFragmentCardShadowTransformer);
    } else {
        mButton.setText("Fragments");
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
    }

    mShowingFragments = !mShowingFragments;

    }
    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
}
