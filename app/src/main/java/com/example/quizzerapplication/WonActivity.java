
package com.example.quizzerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

import io.grpc.android.BuildConfig;

public class WonActivity extends AppCompatActivity {

    CircularProgressBar circularprogressbar;
    TextView resulttext, correctQTV, wrongQTV;
    int correct, wrong;
    LinearLayout btnshare;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        correct = getIntent().getIntExtra("correct", 0);
        wrong = getIntent().getIntExtra("wrong", 0);

        circularprogressbar = findViewById(R.id.circularprogressbar);
        resulttext = findViewById(R.id.resulttext);
        btnshare = findViewById(R.id.buttonshare);
        correctQTV = findViewById(R.id.correctans);
        wrongQTV = findViewById(R.id.wrongans);

        correctQTV.setText(String.valueOf(correct));
        wrongQTV.setText(String.valueOf(wrong));

        circularprogressbar.setProgress(correct);
        resulttext.setText(correct+ "/7");

        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage = "\nI got" + correct + "out of 7 you can also try";
                    shareMessage = shareMessage + "http://play.google.com/store/apps/detail?id=" + BuildConfig.BUILD_TYPE + "\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {
                    //e.tostring();
                }
            }
        });

    }
}