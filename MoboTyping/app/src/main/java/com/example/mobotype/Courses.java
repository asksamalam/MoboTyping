package com.example.mobotype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Courses extends AppCompatActivity {
    int one=1,two=2,three=3,four=4,five=5,six=6,seven=7,eight=8,nine=9,ten=10,eleven=11,twelve=12,thirteen=13,fourteen=14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14;
        Intent myIntent = new Intent(Courses.this,LessonTyping.class);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btn10=findViewById(R.id.btn10);
        btn11=findViewById(R.id.btn11);
        btn12=findViewById(R.id.btn12);
        btn13=findViewById(R.id.btn13);
        btn14=findViewById(R.id.btn14);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(one));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(two));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(three));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(four));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(five));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(six));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(seven));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(eight));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(nine));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(ten));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(eleven));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(twelve));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle extras = new Bundle();
                extras.putString("stringInt", String.valueOf(thirteen));
                myIntent.putExtras(extras);
                startActivity(myIntent);
            }
        });
        btn14.setOnClickListener(view -> {
            Bundle extras = new Bundle();
            extras.putString("stringInt", String.valueOf(fourteen));
            myIntent.putExtras(extras);
            startActivity(myIntent);
        });

    }

}