package com.example.quizzerapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public class Register extends AppCompatActivity {

    public static final String TAG ="TAG";

    EditText mfullname, memail, mpassword, mphone;
    TextView mregisterbtn, mloginbtn;
    ProgressBar progressBar;
    String UserId;
    FirebaseAuth fauth;
    FirebaseFirestore fstore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mfullname = findViewById(R.id.fullname);
        memail = findViewById(R.id.Email);
        mpassword = findViewById(R.id.password);
        mphone = findViewById(R.id.phone);
        mregisterbtn = findViewById(R.id.registerbtn);
        mloginbtn = findViewById(R.id.createtext);
        progressBar = findViewById(R.id.progressbar);

        fauth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();



        if (fauth.getCurrentUser() != null)
        {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        mloginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        mregisterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                final String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();
                final String fullname = mfullname.getText().toString();
                final String phone = mphone.getText().toString();

                if (TextUtils.isEmpty(email)) {

                    memail.setError("Email is required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {

                    mpassword.setError("Password is required");
                    return;
                }
                if (password.length()<6) {

                    mpassword.setError("Password must be >=6 characters");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);



                fauth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            FirebaseUser fuser = fauth.getCurrentUser();
                            fuser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                    Toast.makeText(Register.this, "Register Successful", Toast.LENGTH_SHORT).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Log.d(TAG, "Email not sent" + e.getMessage());

                                }
                            });


                            Toast.makeText(Register.this, "User created", Toast.LENGTH_SHORT).show();
                            UserId = fauth.getCurrentUser().getUid();
                            DocumentReference documentReference = fstore.collection("users").document(UserId);
                            Map<String, Object> user = new HashMap<>();
                            user.put("fname", fullname);
                            user.put("email", email);
                            user.put("phone", phone);
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {

                                    Log.d(TAG,"Onsuccess:user profile is created for" + UserId);

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                    Log.d(TAG, "Onfailure:" +e.toString());

                                }
                            });


                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else {
                            Toast.makeText(Register.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });


    }
}