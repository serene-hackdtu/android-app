package com.example.nipunarora.hackdtu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Diagonosis extends AppCompatActivity {
    AppCompatButton diagonosis;
    AppCompatTextView disease,remedy,test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagonosis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       disease=(AppCompatTextView)findViewById(R.id.disease);
        remedy=(AppCompatTextView)findViewById(R.id.remedies);
        test=(AppCompatTextView)findViewById(R.id.test);
        disease.setText(getIntent().getStringExtra("disease"));
        remedy.setText(getIntent().getStringExtra("remedy"));
        test.setText(getIntent().getStringExtra("Test"));

    }

}
