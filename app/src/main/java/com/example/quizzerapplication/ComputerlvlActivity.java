package com.example.quizzerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class ComputerlvlActivity extends AppCompatActivity {

    public static ArrayList<modelcomputer> listCB;

    TextView btn1, btn2, btn3;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathematicslvl);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listCB = new ArrayList<>();

                databaseReference = FirebaseDatabase.getInstance().getReference("CBeasy");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot dataSnapshot:snapshot.getChildren())
                        {
                            modelcomputer modelcomputer = dataSnapshot.getValue(modelcomputer.class);
                            listCB.add(modelcomputer);
                        }
                        Intent intent = new Intent(ComputerlvlActivity.this,QuestionComputerActivity.class);
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
                listCB = new ArrayList<>();

                databaseReference = FirebaseDatabase.getInstance().getReference("CBmedium");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot dataSnapshot:snapshot.getChildren())
                        {
                            modelcomputer modelcomputer = dataSnapshot.getValue(modelcomputer.class);
                            listCB.add(modelcomputer);
                        }
                        Intent intent = new Intent(ComputerlvlActivity.this, QuestionComputerActivity.class);
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
                listCB = new ArrayList<>();

                databaseReference = FirebaseDatabase.getInstance().getReference("CBhard");

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        for(DataSnapshot dataSnapshot:snapshot.getChildren())
                        {
                            modelcomputer modelcomputer = dataSnapshot.getValue(modelcomputer.class);
                            listCB.add(modelcomputer);
                        }
                        Intent intent = new Intent(ComputerlvlActivity.this, QuestionComputerActivity.class);
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