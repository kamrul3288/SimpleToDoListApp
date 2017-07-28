package falcon_007.kamrulhasan.simpletodolistapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreenActivity extends AppCompatActivity {

    //------splash screen length
    public static final int SPLASH_SCREEN_LENGTH = 4000; //4 SEC

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //--- CALL THREAD
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //-----SWITCH ACTIVITY-----
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        },SPLASH_SCREEN_LENGTH);
    }
}
