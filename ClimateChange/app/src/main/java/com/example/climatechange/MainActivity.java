package com.example.climatechange;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;

public class MainActivity extends AppCompatActivity {
    MaterialCardView cardView1, cardView2, cardView3, cardView4, cardView5, cardView6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        cardView1 = findViewById(R.id.courses);
        cardView2 = findViewById(R.id.videos);
        cardView3 = findViewById(R.id.quizzes);
        cardView4 = findViewById(R.id.news);
        cardView5 = findViewById(R.id.contribute);
        cardView6 = findViewById(R.id.weather);
        cardView1.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,HomePage.class);
            intent.putExtra("tag","course");
            startActivity(intent);
        });
        cardView2.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,HomePage.class);
            intent.putExtra("tag","video");
            startActivity(intent);
        });
        cardView3.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,HomePage.class);
            intent.putExtra("tag","quiz");
            startActivity(intent);
        });
        cardView4.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,HomePage.class);
            intent.putExtra("tag","news");
            startActivity(intent);
        });
        cardView5.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,HomePage.class);
            intent.putExtra("tag","contribution");
            startActivity(intent);
        });
        cardView6.setOnClickListener(view -> {
            Intent intent=new Intent(MainActivity.this,HomePage.class);
            intent.putExtra("tag","weather");
            startActivity(intent);
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == R.id.exit) {
            SharedPreferences preferences = getSharedPreferences("Login", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.apply();
            finish();
            Toast.makeText(this, "Log Out...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}