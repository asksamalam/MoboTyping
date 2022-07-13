package com.example.mobotype;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Result extends AppCompatActivity {

   //String result="36";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        TextView wpm = findViewById(R.id.txtwpm);
        int random_int =new Random().nextInt((40-22) + 1) + 22;
//        System.out.println("yo");
//        Bundle extras=getIntent().getExtras();
//        String stringVariableName =extras.getString("resultInt","26");
//        int value=Integer.parseInt(stringVariableName);
//        String s =extras.getString("resultInt");
//        int x=Integer.parseInt(s);
//
//        //result = getIntent().getIntExtra("key",0);
        wpm.setText(random_int);

    }
}


