package csc207.phase2.UTFantasy.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import csc207.phase2.UTFantasy.R;

public class EndingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ending);

        ImageView dd = findViewById(R.id.pic1);
        dd.setImageResource(R.drawable.dd);
        ImageView yimi = findViewById(R.id.pic2);
        yimi.setImageResource(R.drawable.yimi);
        ImageView jessie = findViewById(R.id.pic3);
        jessie.setImageResource(R.drawable.jesse);
        ImageView quincy = findViewById(R.id.pic4);
        quincy.setImageResource(R.drawable.psyduck);
        ImageView joy = findViewById(R.id.pic5);
        joy.setImageResource(R.drawable.yyqx);

        Button back = findViewById(R.id.ending_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startup = new Intent(EndingActivity.this, StartUpActivity.class);
                startActivity(startup);
            }
        });

    }
}
