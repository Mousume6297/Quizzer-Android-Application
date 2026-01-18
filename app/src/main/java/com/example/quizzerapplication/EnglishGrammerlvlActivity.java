package com.example.quizzerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class EnglishGrammerlvlActivity extends AppCompatActivity {

    public static ArrayList<modeleng> listE;
    TextView btn1, btn2, btn3;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_grammerlvl);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listE = new ArrayList<>();

                databaseReference = FirebaseDatabase.getInstance().getReference("EGeasy");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot dataSnapshot:snapshot.getChildren())
                        {
                            modeleng modeleng = dataSnapshot.getValue(modeleng.class);
                            listE.add(modeleng);
                        }
                        Intent intent = new Intent(EnglishGrammerlvlActivity.this, QuestionEngActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listE = new ArrayList<>();

                databaseReference = FirebaseDatabase.getInstance().getReference("EGmedium");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot dataSnapshot:snapshot.getChildren())
                        {
                            modeleng modeleng = dataSnapshot.getValue(modeleng.class);
                            listE.add(modeleng);
                        }
                        Intent intent = new Intent(EnglishGrammerlvlActivity.this, QuestionEngActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listE = new ArrayList<>();

                databaseReference = FirebaseDatabase.getInstance().getReference("EGhard");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot dataSnapshot:snapshot.getChildren())
                        {
                            modeleng modeleng = dataSnapshot.getValue(modeleng.class);
                            listE.add(modeleng);
                        }
                        Intent intent = new Intent(EnglishGrammerlvlActivity.this, QuestionEngActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });


            }
        });

    }
}