package com.example.mobotype;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Random;

public class SingleWordActivity extends AppCompatActivity {
    TextView txtViewSingle;
    EditText edtTextWriter;
    ImageView imageView;
    Button fPButton,endTest;
    InputStream streamCountLines;
    BufferedReader readerCountLines;
    InputStream inputStream;
    BufferedReader bufferedReader;
    boolean flag=false,startTimerFlag=false;
    int intCount =0;
    int intCurrent;
    int spaceNo=0;
    int result=0;
    public int rightWord=0,wrongWord=0;
    String[] textData;
    String currentWord="";
    //timer variables
    private static final long START_TIME_IN_MILLIS = 600000;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    public long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_word);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        //EditText edittext = (EditText) findViewById(R.id.edtTextWriter);
        edtTextWriter=findViewById(R.id.edtTextWriter);
        txtViewSingle=findViewById(R.id.txtViewSingle);
        imageView=findViewById(R.id.imageView);
        fPButton=findViewById(R.id.fPButton);
        endTest=findViewById(R.id.endTest);
        imageView=findViewById(R.id.imageView);
        Intent intent = new Intent(getApplicationContext(),Result.class);
        //timer id's
        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);
        //TextFile extraction
        streamCountLines=this.getResources().openRawResource(R.raw.words);
        readerCountLines=new BufferedReader(new InputStreamReader(streamCountLines));
        //count no. of lines in a textfile
        try{
            while(readerCountLines.readLine()!=null){
                intCount++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        inputStream=this.getResources().openRawResource(R.raw.words);
        bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
        //Toast.makeText(this,String.valueOf(intCount).toString(),Toast.LENGTH_SHORT).show();
        textData = new String[intCount];
        try {
            for(int i=0; i<intCount; i++){
                textData[i]=bufferedReader.readLine();
            }
        }catch (Exception f){
            f.printStackTrace();
        }
        txtViewSingle.setText(textData[0]);
        intCurrent=0;
        //event on button click
        fPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.GONE);
            }
        });
        //endTest Button
        endTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pauseTimer();
                //Toast.makeText(getApplicationContext(), wrongWord, Toast.LENGTH_SHORT).show();
//                    result=wpm(rightWord,wrongWord,mTimeLeftInMillis);
//                    Bundle extras = new Bundle();
//                    extras.putString("resultInt", String.valueOf(result));
//                    intent.putExtras(extras);
                startActivity(intent);
//                int min=10,max=50;
//                int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
//                int random_int =new Random().nextInt((max - min) + 1) + min;
                //intent.putExtra("key",random_int);
                finish();
            }
        });

    for(int i=0; i<intCount; i++){

        edtTextWriter.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //start Timer
                if (startTimerFlag==false) {
                    startTimer();
                    startTimerFlag = true;
                }

                // If the event is a key-down event on the "Space" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_SPACE)) {
                    // Perform action on key press

                    currentWord = edtTextWriter.getText().toString().trim();

                    spellCheck(currentWord,spaceNo);
                    if(flag==true){
                        spaceNo++;
                    }

                    return true;
                }
                return false;

            }


        });
    }

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                }
                else {
                      startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        updateCountDownText();

    }
    public boolean spellCheck(@NonNull String currentWord, int spaceNo){


            if(textData[spaceNo].equals(currentWord)){
                spaceNo++;
                //Toast.makeText(getApplicationContext(), textData[spaceNo], Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(), currentWord, Toast.LENGTH_SHORT).show();
                txtViewSingle.setTextColor(getResources().getColor(R.color.Green));
                txtViewSingle.setText(textData[spaceNo]);
                edtTextWriter.setText("");
                flag=true;
                this.rightWord++;
            }
            else{
                txtViewSingle.setTextColor(getResources().getColor(R.color.Red));
                flag=false;
                this.wrongWord++;
            }

        return flag;
    }
    //timer Functions
    public void startTimer() {
        mButtonStartPause.setVisibility(View.VISIBLE);
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();

            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                //mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);

            }
        }.start();

        mTimerRunning = true;

        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    public void pauseTimer() {

        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        Toast.makeText(getApplicationContext(), "Rambo", Toast.LENGTH_SHORT).show();
        mButtonReset.setVisibility(View.VISIBLE);
    }

    public void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE );
    }

    public void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);
    }
    public int wpm(int rightWord,int wrongWord,long mTimeLeftInMillis){
        float speed;
        float time=(600000-mTimeLeftInMillis)/(1000*60);
        speed=(rightWord-wrongWord)/time;
        final int speed1 = (int) speed;
        return speed1;

    }
}