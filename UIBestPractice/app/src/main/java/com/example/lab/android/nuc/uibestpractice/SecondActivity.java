package com.example.lab.android.nuc.uibestpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
//        Person person = (Person) getIntent().getSerializableExtra("person_data");
    }
}
