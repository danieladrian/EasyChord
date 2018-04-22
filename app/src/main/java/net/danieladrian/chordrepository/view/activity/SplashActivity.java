package net.danieladrian.chordrepository.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import net.danieladrian.chordrepository.R;
import net.danieladrian.chordrepository.utility.SharedPreference;


public class SplashActivity extends AppCompatActivity {

    SharedPreference sharedPreference;
    private Handler handler;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(sharedPreference.getUserID().equalsIgnoreCase("")) {
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedPreference = new SharedPreference(getApplicationContext());

        if(!sharedPreference.getInitialized()){
            sharedPreference.defaultConfig();
        }
        handler = new Handler();
        handler.postDelayed(runnable,3000);

    }
}
