package com.example.menu_201b041;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView textView;
    SharedPreferences sharedPref;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        super.onOptionsItemSelected(item);
        switch(item.getItemId())
        {
            case R.id.eng:
                textView.setText("English");
                sharedPref.edit().putString("title","English").apply();
                return true;

            case R.id.hin:
                textView.setText("Hindi");
                sharedPref.edit().putString("title","Hindi").apply();
                return true;

            default:
                return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        sharedPref=this.getSharedPreferences("com.example.menu_201b041",0);
        String pref = sharedPref.getString("title","default");
        textView.setText(pref);
    }
}