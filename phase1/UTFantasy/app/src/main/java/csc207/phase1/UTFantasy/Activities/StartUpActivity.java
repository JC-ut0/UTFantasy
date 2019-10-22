package csc207.phase1.UTFantasy.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import csc207.phase1.UTFantasy.R;

/**
 * The activity that got launched when launching the app
 * Showing the start up picture for 5 seconds and then go to
 */
public class StartUpActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set the content view of this activity to be activity_start_up
        setContentView(R.layout.activity_start_up);

        //create a thread for this activity
        Thread thread = new Thread()
        {
            //override run method

            @Override
            public void run() {
                try{
                    // show the start up picture for 5 seconds
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // call the intent to go to next activity
                    Intent intent = new Intent(StartUpActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };

        // call the thread
        thread.start();
    }
}
