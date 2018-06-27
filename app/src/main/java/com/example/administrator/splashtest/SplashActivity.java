package com.example.administrator.splashtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class SplashActivity extends AppCompatActivity {
    private LinearLayout logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Animation fadeIn = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fade_in);

        logo = findViewById(R.id.logo);
        logo.setAnimation(fadeIn);
        Thread timer = new Thread(){
            @Override
            public void run() {
                super.run();
                try{
                    sleep(3000);

                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                finally{

                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                    overridePendingTransition(android.R.anim.fade_out,android.R.anim.fade_in);

                }
            }
        };
        timer.start();
    }
}
