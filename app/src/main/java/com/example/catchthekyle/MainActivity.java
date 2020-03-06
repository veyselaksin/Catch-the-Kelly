package com.example.catchthekyle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timeText;
    TextView scoreText;
    protected int score;

    ImageView kyle1;
    ImageView kyle2;
    ImageView kyle3;
    ImageView kyle4;
    ImageView kyle5;
    ImageView kyle6;
    ImageView kyle7;
    ImageView kyle8;
    ImageView kyle9;
    int imageshow;
    ImageView[] imageArray;

    Handler handler;
    Runnable runnable;

    Button buttonStart;

    boolean pause_flg=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText=(TextView) findViewById(R.id.timeText);
        scoreText=(TextView) findViewById(R.id.scoreText);
        kyle1=findViewById(R.id.kyle1);
        kyle2=findViewById(R.id.kyle2);
        kyle3=findViewById(R.id.kyle3);
        kyle4=findViewById(R.id.kyle4);
        kyle5=findViewById(R.id.kyle5);
        kyle6=findViewById(R.id.kyle6);
        kyle7=findViewById(R.id.kyle7);
        kyle8=findViewById(R.id.kyle8);
        kyle9=findViewById(R.id.kyle9);


        imageArray=new ImageView[]{kyle1,kyle2,kyle3,kyle4,kyle5,kyle6,kyle7,kyle8,kyle9};
        //Geriye Doğru Sayma fonksiyonu
        hideImages();
        Count();
    }

    public void increaseScore(View view){
        //Skoru 1 arttırma yapıyoruz....

        score++;
       scoreText.setText("Score: "+score);


    }
    //Zamanı ayarla
    public void Count(){

       if(score<=15){
            new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    timeText.setText("Time: "+millisUntilFinished/1000+"s");
                }

                @Override
                public void onFinish() {
                    stop();

                }

            }.start();
        }
       else if(score<=30){
           new CountDownTimer(10000, 1000) {
               @Override
               public void onTick(long millisUntilFinished) {
                   timeText.setText("Time: "+millisUntilFinished/500+"s");
               }

               @Override
               public void onFinish() {
                   timeText.setText("Fnished!");


               }
           }.start();
        }
       else if(score<45){
           new CountDownTimer(10000, 1000) {
               @Override
               public void onTick(long millisUntilFinished) {
                   timeText.setText("Time: "+millisUntilFinished/100+"s");
               }

               @Override
               public void onFinish() {
                   timeText.setText("Fnished!");


               }
           }.start();
       }


    }
    //Resimi visible ve invisible yapma kısmı
    public void hideImages(){
        handler=new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);
                }

                Random random=new Random();
                imageshow=random.nextInt(9);
                imageArray[imageshow].setVisibility(View.VISIBLE);

                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);
    }


    public void stop(){
        runnable = new Runnable() {
            @Override
            public void run() {
                for(ImageView image: imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
            }
        };


        timeText.setText("Fnished!!");
    }
}
