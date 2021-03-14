package com.example.climatechange;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.climatechange.adapter.BackPressedListener;
import com.example.climatechange.fragments.Contribution;
import com.example.climatechange.fragments.Course;
import com.example.climatechange.fragments.News;
import com.example.climatechange.fragments.Quiz;
import com.example.climatechange.fragments.Video;
import com.example.climatechange.fragments.Weather;
import java.util.List;
import java.util.Objects;

public class HomePage extends AppCompatActivity {

    String tag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        tag = Objects.requireNonNull(getIntent().getExtras()).getString("tag");
        assert tag != null;
        Log.e("tag", tag);

        switch (tag) {
            case "course": {
                openFragment(new Course());
                break;
            }
            case "video": {
                openFragment(new Video());
                break;
            }
            case "quiz": {
                openFragment(new Quiz());
                break;
            }
            case "news": {
                openFragment(new News());
                break;
            }
            case "contribution": {
                openFragment(new Contribution());
                break;
            }
            case "weather": {
                openFragment(new Weather());
                break;

            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void openFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.home, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        List<Fragment> fragmentList = getSupportFragmentManager().getFragments();
        for (Fragment fragment : fragmentList) {
            if (fragment instanceof BackPressedListener) {
                ((BackPressedListener) fragment).onBackPressed();
            }
        }
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
}