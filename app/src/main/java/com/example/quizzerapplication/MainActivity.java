package com.example.quizzerapplication;

import static com.example.quizzerapplication.R.id.nav_terms_conditions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;


import com.google.android.material.navigation.NavigationView;
import com.google.firebase.components.BuildConfig;

public class MainActivity extends AppCompatActivity {


    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;

    final int nav_privacy_policy=1, nav_terms_condition=2, more=3, nav_rate=4, nav_share=5;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerlayout);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new
                                                                 NavigationView.OnNavigationItemSelectedListener() {
                                                                     @SuppressLint("NonConstantResourceId")
                                                                     @Override
                                                                     public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                                                         switch (item.getItemId()) {
                                                                             case R.id.nav_terms_conditions:
                                                                                 Intent intent = new Intent(MainActivity.this, Privacypolicy.class);
                                                                                 startActivity(intent);
                                                                                 break;
                                                                             // COMMON
                                                                             // IMPORTANT //
                                                                             case R.id.nav_rate:
                                                                                 Uri uri = Uri.parse("market://details?id=" + getApplication().getPackageName());
                                                                                 Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                                                                                 // To count with Play market backstack, After pressing back button,
                                                                                 // to taken back to our application, we need to add following flags to intent.
                                                                                 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                                                                     goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                                                                                             Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                                                                                             Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                                                                                 }
                                                                                 try {
                                                                                     startActivity(goToMarket);
                                                                                 } catch (ActivityNotFoundException e) {
                                                                                     startActivity(new Intent(Intent.ACTION_VIEW,
                                                                                             Uri.parse("http://play.google.com/store/apps/details?id=" + getApplication().getPackageName())));
                                                                                 }

                                                                                 break;
                                                                             // IMPORTANT //
                                                                             // IMPORTANT //
                                                                             case R.id.nav_share:
                                                                                 Intent shareIntent = new Intent(Intent.ACTION_SEND);
                                                                                 shareIntent.setType("text/plain");
                                                                                 shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Quiz App");
                                                                                 String shareMessage= "This Is Best Application For Quiz App.\n\n";
                                                                                 shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;
                                                                                 shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                                                                                 startActivity(Intent.createChooser(shareIntent, "choose one"));
                                                                                 break;
                                                                             // IMPORTANT //
                                                                             case R.id.nav_logout:
                                                                                 Intent intent1 = new Intent(MainActivity.this, Login.class);
                                                                                 startActivity(intent1);
                                                                                 Toast.makeText(MainActivity.this, "You are Logged out", Toast.LENGTH_SHORT).show();
                                                                                 break;
                                                                         }
                                                                         return true;
                                                                     }
                                                                 });

    }




    public void current_affairs(View view){

        Intent intent = new Intent(MainActivity.this, LevelActivity.class);
        startActivity(intent);

    }
    public void english_grammer(View view){

        Intent intent = new Intent(MainActivity.this, EnglishGrammerlvlActivity.class);
        startActivity(intent);

    }
    public void mathematics(View view){

        Intent intent = new Intent(MainActivity.this, MathematicslvlActivity.class);
        startActivity(intent);

    }
    public void programming_language(View view){

        Intent intent = new Intent(MainActivity.this, ProgramminglvlActivity.class);
        startActivity(intent);


    }
    public void computer_basics(View view){

        Intent intent = new Intent(MainActivity.this, ComputerlvlActivity.class);
        startActivity(intent);

    }
    public void sports(View view){

        Intent intent = new Intent(MainActivity.this, SportslvlActivity.class);
        startActivity(intent);

    }
}