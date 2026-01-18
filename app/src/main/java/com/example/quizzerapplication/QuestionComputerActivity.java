package com.example.quizzerapplication;

import static com.example.quizzerapplication.ComputerlvlActivity.listCB;
import static com.example.quizzerapplication.EnglishGrammerlvlActivity.listE;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionComputerActivity extends AppCompatActivity {

    ArrayList<modelcomputer> allquestionlistCB;
    modelcomputer modelcomputer;
    int indexCB = 0;
    TextView card_question, optionA, optionB, optionC, optionD;
    CardView cardA, cardB, cardC, cardD;
    int correctcount = 0;
    int wrongcount = 0;
    LinearLayout nextbtn;
    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_eng);

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

        allquestionlistCB = listCB;
        Collections.shuffle(allquestionlistCB);
        modelcomputer = listCB.get(indexCB);

        card_question.setBackgroundColor(getResources().getColor(R.color.white));
        cardA.setBackgroundColor(getResources().getColor(R.color.white));
        cardB.setBackgroundColor(getResources().getColor(R.color.white));
        cardC.setBackgroundColor(getResources().getColor(R.color.white));
        cardD.setBackgroundColor(getResources().getColor(R.color.white));

        nextbtn.setClickable(false);



        setAllData();

    }

    private void setAllData() {

        card_question.setText(modelcomputer.getQuestionCB());
        optionA.setText(modelcomputer.getoACB());
        optionB.setText(modelcomputer.getoBCB());
        optionC.setText(modelcomputer.getoCCB());
        optionD.setText(modelcomputer.getoDCB());
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
                indexCB++;
                modelcomputer=listCB.get(indexCB);
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
                if(indexCB<listCB.size()-1)
                {
                    indexCB++;
                    modelcomputer=listCB.get(indexCB);
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
        Intent intent = new Intent(QuestionComputerActivity.this, WonActivity.class);
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
        if(modelcomputer.getoACB().equals(modelcomputer.getansCB()))
        {
            cardA.setCardBackgroundColor(getResources().getColor(R.color.grey));

            if(indexCB<listCB.size() - 1)
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
        if(modelcomputer.getoBCB().equals(modelcomputer.getansCB()))
        {
            cardB.setCardBackgroundColor(getResources().getColor(R.color.grey));

            if(indexCB<listCB.size() - 1)
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
        if(modelcomputer.getoCCB().equals(modelcomputer.getansCB()))
        {
            cardC.setCardBackgroundColor(getResources().getColor(R.color.grey));

            if(indexCB<listCB.size() - 1)
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
        if(modelcomputer.getoDCB().equals(modelcomputer.getansCB()))
        {
            cardD.setCardBackgroundColor(getResources().getColor(R.color.grey));

            if(indexCB<listCB.size() - 1)
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