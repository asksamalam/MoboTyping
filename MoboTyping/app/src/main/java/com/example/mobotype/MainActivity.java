package com.example.mobotype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn_Sword, btn_Para,btnCourse;
    TextView txtwelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtwelcome = findViewById(R.id.welcome);
        btn_Sword = findViewById(R.id.btn_Sword);
        btn_Para = findViewById(R.id.btn_para);
        btnCourse = findViewById(R.id.btnCourse);
        String value = getIntent().getStringExtra("key");
        txtwelcome.setText(value);
        btn_Sword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent SingleWord;
                SingleWord = new Intent(MainActivity.this,SingleWordActivity.class);
                startActivity(SingleWord);
            }
        });
        btn_Para.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Para;
                Para = new Intent(MainActivity.this,ParagraphMode.class);

                startActivity(Para);
            }
        });
        btnCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Course = new Intent(MainActivity.this,Courses.class);
                startActivity(Course);
            }
        });

    }
}