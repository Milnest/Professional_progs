/*
 * Copyright (c) 2018. milnest.
 */

package com.milnest.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resField = findViewById(R.id.resultField);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newMethod();
    }

    private void newMethod() {
        resField.setText("Test");
    }
}
