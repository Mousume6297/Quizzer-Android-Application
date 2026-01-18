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

public class ProgramminglvlActivity extends AppCompatActivity {

    public static ArrayList<modelPL> listPL;
    TextView btn1, btn2, btn3;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programminglvl);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listPL = new ArrayList<>();

                databaseReference = FirebaseDatabase.getInstance().getReference("PLeasy");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            modelPL modelPL = dataSnapshot.getValue(modelPL.class);
                            listPL.add(modelPL);
                        }
                        Intent intent = new Intent(ProgramminglvlActivity.this, QuestionProgrammingActivity.class);
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
                listPL = new ArrayList<>();

                databaseReference = FirebaseDatabase.getInstance().getReference("PLmedium");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot dataSnapshot:snapshot.getChildren())
                        {
                            modelPL modelPL = dataSnapshot.getValue(modelPL.class);
                            listPL.add(modelPL);
                        }
                        Intent intent = new Intent(ProgramminglvlActivity.this, QuestionProgrammingActivity.class);
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
                listPL = new ArrayList<>();

                databaseReference = FirebaseDatabase.getInstance().getReference("PLhard");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot dataSnapshot:snapshot.getChildren())
                        {
                            modelPL modelPL = dataSnapshot.getValue(modelPL.class);
                            listPL.add(modelPL);
                        }
                        Intent intent = new Intent(ProgramminglvlActivity.this, QuestionProgrammingActivity.class);
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
