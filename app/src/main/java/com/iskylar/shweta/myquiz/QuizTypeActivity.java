package com.iskylar.shweta.myquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.infideap.drawerbehavior.AdvanceDrawerLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class QuizTypeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    android.content.res.Resources res;



public int id[]={
  1,2,3,4,5,6,7,8,9
};

    public int Image_recycler[] = {
            R.drawable.dance2, R.drawable.music, R.drawable.guess,
            R.drawable.dance, R.drawable.music, R.drawable.guess,
            R.drawable.dance2, R.drawable.music, R.drawable.guess
    };

    String des[];

    private AdvanceDrawerLayout drawer;
    //Recyclerview
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private static String LOG_TAG = "CardView";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_type);
//nav
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (AdvanceDrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.setViewScale(Gravity.START, 0.9f);
        drawer.setRadius(Gravity.START, 35);
        drawer.setViewElevation(Gravity.START, 20);
        //nav end
        res = getResources();


        // recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_material);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mAdapter = new Adapter_recyclerview_QuizType(QuizTypeActivity.this,getDataSet() );
        mRecyclerView.setAdapter(mAdapter);

//
    }

    private  ArrayList<Data_cardview_QuizType> getDataSet(){
        ArrayList results=new ArrayList<Data_cardview_QuizType>();

        for (int index=0;index<Image_recycler.length;index++) {

            results.add(new Data_cardview_QuizType( Image_recycler[index]));

        }
        return results;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    // main code

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
