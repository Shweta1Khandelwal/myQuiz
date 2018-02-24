package com.iskylar.shweta.myquiz;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Detail_timeleftActivity extends AppCompatActivity {
ImageView img;
    Button btn;
    Bitmap bmp;
    private final int ID[]={
      1,2,3,4,5,6,4,5,6,7,8,9
    };

    public int images[]={
            R.drawable.dance,R.drawable.music,R.drawable.guess,
            R.drawable.dance,R.drawable.music,R.drawable.guess,
            R.drawable.dance,R.drawable.music,R.drawable.guess
    };
    private TextView txtDay, txtHour, txtMinute, txtSecond;
    private TextView tvEventStart;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_timeleft);
        btn= (Button) findViewById(R.id.btn_join);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),QuizQuestionActivity.class);
                startActivity(i);
            }
        });
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar_detail);
        toolbar.setTitle("Detail");
        setSupportActionBar(toolbar);
        img= (ImageView) findViewById(R.id.image_detail);
        Intent intent=getIntent();
        final ArrayList<Detail_data> objects=new ArrayList<>();
        int imageid=intent.getIntExtra("img",0);
       final int pos=intent.getIntExtra("POSITION",0);
        for(int i=0;i<images.length;i++){
            int id=images[i];
            if(id==imageid){
                objects.add( new Detail_data(id,images[i]));
            }
        }
img.setImageResource(imageid);

        txtDay = (TextView) findViewById(R.id.txtDay);
        txtHour = (TextView) findViewById(R.id.txtHour);
        txtMinute = (TextView) findViewById(R.id.txtMinute);
        txtSecond = (TextView) findViewById(R.id.txtSecond);
        tvEventStart = (TextView) findViewById(R.id.tveventStart);

        countDownStart();
    }
    public void countDownStart(){
        handler=new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
                    // Please here set your event date//YYYY-MM-DD
                    Date futureDate = dateFormat.parse("2018-5-30");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtDay.setText("" + String.format("%02d ", days));
                        txtHour.setText("" + String.format("%02d ", hours));
                        txtMinute.setText(""
                                + String.format("%02d ", minutes));
                        txtSecond.setText(""
                                + String.format("%02d ", seconds));
                    } else {
                        tvEventStart.setVisibility(View.VISIBLE);
                        tvEventStart.setText("The event started!");
                        // textViewGone();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }
}
