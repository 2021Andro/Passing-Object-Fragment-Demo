package com.example.fragmentlistviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragmentlistviewdemo.Fragments.InputFrag;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainerView, new InputFrag())
                .commit();

    }
}