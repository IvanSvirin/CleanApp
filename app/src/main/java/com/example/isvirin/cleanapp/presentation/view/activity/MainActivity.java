package com.example.isvirin.cleanapp.presentation.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.isvirin.cleanapp.R;
import com.example.isvirin.cleanapp.presentation.view.fragment.AutoListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment, new AutoListFragment());
    }
}
