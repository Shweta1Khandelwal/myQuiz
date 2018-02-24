package com.iskylar.shweta.myquiz;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Shweta on 9/1/2017.
 */
public class Adapter_viewpager_Quiz extends PagerAdapter {

    data_viewpager_quiz data;
    ViewPager viewPager;
    LayoutInflater layoutInflater;
    Activity context;
    ArrayList<data_viewpager_quiz> objects=new ArrayList<>();




    public Adapter_viewpager_Quiz(Activity context, ArrayList<data_viewpager_quiz> objects) {
        this.context = context;
        this.objects = objects;
        layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==((LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=layoutInflater.inflate(R.layout.viewpagerquiz_layout,container,false);
        data=objects.get(position);
        viewPager= (ViewPager) view.findViewById(R.id.view_Pager);
        ImageView imageView= (ImageView) view.findViewById(R.id.image_viewpager);
        imageView.setImageResource(data.getImage());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView((LinearLayout)object);
    }



}
