package com.safejourney;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        View decorView=getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
                String pho=sharedPreferences.getString("phone","");
                Intent intent;

                if(pho.compareTo("")==0)
                    intent = new Intent(SplashScreen.this,
                        ResqstPhno.class);
                else
                    intent= new Intent(SplashScreen.this,MainActivity.class);

                startActivity(intent);
                finish();
            }
        },1000);
    }
}
