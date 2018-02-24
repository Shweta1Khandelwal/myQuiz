package com.iskylar.shweta.myquiz;

import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.infideap.drawerbehavior.AdvanceDrawerLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    ViewPager viewPager1;
    Adapter_viewpager_Quiz adapter;
    int currentpage = 0;
    Timer timer;
    final long Delay_MS = 500;
    android.content.res.Resources res;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    final long Period_MS = 3000;
    public int Images[] = {
            R.drawable.music, R.drawable.dance4
    };

    //nav
    private AdvanceDrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//slideshow
        res = getResources();


        viewPager1 = (ViewPager) findViewById(R.id.viewPager);
        setupViewPager(viewPager1);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager1);

// view pager
        viewPager = (ViewPager) findViewById(R.id.view_Pager);
        final ArrayList<data_viewpager_quiz> object = new ArrayList<>();
        for (int i = 0; i < Images.length; i++) {
            object.add(new data_viewpager_quiz(Images[i]));
        }
        adapter = new Adapter_viewpager_Quiz(MainActivity.this, object);
        viewPager.setAdapter(adapter);

        final Runnable update = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= Images.length; i++) {
                    if (currentpage == Images.length) {
                        currentpage = 0;
                    }
                    viewPager.setCurrentItem(currentpage++, false);

                }

            }

        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                viewPager.post(update);
            }
        }, Delay_MS, Period_MS);


        //navigation
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.bg_screen2));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");


        drawer = (AdvanceDrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer,toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.bg_screen2));
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawer.setViewScale(Gravity.START, 0.9f);
        drawer.setRadius(Gravity.START, 65);
        drawer.setViewElevation(Gravity.START, 40);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new LoginFragment(), "LOGIN");
        adapter.addFrag(new SignupFragmnet(), "SIGNUP");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFrag(Fragment fragment,String title){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);

        }
        @Override
        public CharSequence getPageTitle(int position) {
           /* return null; *///if dont want any title
            return mFragmentTitleList.get(position);
        }
    }
    //nav

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}


