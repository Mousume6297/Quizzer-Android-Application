package com.example.quizzerapplication;

import static com.example.quizzerapplication.LevelActivity.list;

import static java.util.Collections.shuffle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class QuestionActivity extends AppCompatActivity {

    List<Model> allquestionlist;
    Model model;
    int index = 0;
    TextView card_question, optionA, optionB, optionC, optionD;
    CardView cardA, cardB, cardC, cardD;
    int correctcount = 0;
    int wrongcount = 0;
    LinearLayout nextbtn;

    TextView timer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);



        new CountDownTimer(90000, 1000) {
            @Override
            public void onTick(long l) {
                timer.setText("Time Remaining: " + l/1000 + " sec");
            }

            @Override
            public void onFinish() {
                timer.setText("Time is over");


            }
        }.start();




        Hooks();

        allquestionlist = list;
        Collections.shuffle(allquestionlist);
        model = list.get(index);

        card_question.setBackgroundColor(getResources().getColor(R.color.white));
        cardA.setBackgroundColor(getResources().getColor(R.color.white));
        cardB.setBackgroundColor(getResources().getColor(R.color.white));
        cardC.setBackgroundColor(getResources().getColor(R.color.white));
        cardD.setBackgroundColor(getResources().getColor(R.color.white));

        nextbtn.setClickable(false);



        setAllData();

    }

    private void setAllData() {

        card_question.setText(model.getQuestion());
        optionA.setText(model.getoA());
        optionB.setText(model.getoB());
        optionC.setText(model.getoC());
        optionD.setText(model.getoD());
    }

    private void Hooks() {

        card_question = findViewById(R.id.card_question);
        optionA = findViewById(R.id.card_optiona);
        optionB = findViewById(R.id.card_optionb);
        optionC = findViewById(R.id.card_optionc);
        optionD = findViewById(R.id.card_optiond);

        cardA = findViewById(R.id.carda);
        cardB = findViewById(R.id.cardb);
        cardC = findViewById(R.id.cardc);
        cardD = findViewById(R.id.cardd);

        nextbtn = findViewById(R.id.nxtbtn);
        timer = findViewById(R.id.timertext);

    }
    public void corect(CardView cardView) {

        cardView.setBackgroundColor(getResources().getColor(R.color.grey));

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctcount++;
                index++;
                model=list.get(index);
                resetcolor();
                setAllData();
                enablebtn();
            }
        });
    }
    public void wrong(CardView cardA) {

        cardA.setBackgroundColor(getResources().getColor(R.color.grey));

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wrongcount++;
                if(index<list.size()-1)
                {
                    index++;
                    model=list.get(index);
                    resetcolor();
                    setAllData();
                    enablebtn();
                }
                else {
                    Gamewon();
                }

            }
        });

    }

    private void Gamewon() {
        Intent intent = new Intent(QuestionActivity.this, WonActivity.class);
        intent.putExtra("correct", correctcount);
        intent.putExtra("wrong", wrongcount);
        startActivity(intent);
    }
    public void enablebtn() {
        cardA.setClickable(true);
        cardB.setClickable(true);
        cardC.setClickable(true);
        cardD.setClickable(true);
    }
    public void disablebtn() {
        cardA.setClickable(false);
        cardB.setClickable(false);
        cardC.setClickable(false);
        cardD.setClickable(false);
    }
    public void resetcolor() {
        cardA.setBackgroundColor(getResources().getColor(R.color.white));
        cardB.setBackgroundColor(getResources().getColor(R.color.white));
        cardC.setBackgroundColor(getResources().getColor(R.color.white));
        cardD.setBackgroundColor(getResources().getColor(R.color.white));
    }

    public void OptionAClick(View view) {
        disablebtn();
        nextbtn.setClickable(true);
        if(model.getoA().equals(model.getans()))
        {
            cardA.setCardBackgroundColor(getResources().getColor(R.color.grey));

            if(index<list.size() - 1)
            {
                corect(cardA);
            }
            else {
                Gamewon();
            }
        }
        else {
            wrong(cardA);
        }
    }

    public void OptionBClick(View view) {
        disablebtn();
        nextbtn.setClickable(true);
        if(model.getoB().equals(model.getans()))
        {
            cardB.setCardBackgroundColor(getResources().getColor(R.color.grey));

            if(index<list.size() - 1)
            {
               corect(cardB);
            }
            else {
                Gamewon();
            }
        }
        else {
            wrong(cardB);
        }
    }

    public void OptionCClick(View view) {
        disablebtn();
        nextbtn.setClickable(true);
        if(model.getoC().equals(model.getans()))
        {
            cardC.setCardBackgroundColor(getResources().getColor(R.color.grey));

            if(index<list.size() - 1)
            {
                corect(cardC);
            }
            else {
                Gamewon();
            }
        }
        else {
            wrong(cardC);
        }
    }

    public void OptionDClick(View view) {
        disablebtn();
        nextbtn.setClickable(true);
        if(model.getoD().equals(model.getans()))
        {
            cardD.setCardBackgroundColor(getResources().getColor(R.color.grey));

            if(index<list.size() - 1)
            {
                corect(cardD);
            }
            else {
                Gamewon();
            }
        }
        else {
            wrong(cardD);
        }
    }



}