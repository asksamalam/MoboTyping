package com.example.mobotype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

public class LessonTyping extends AppCompatActivity {
    TextView txtCourse;
    InputStream streamCountLines;
    BufferedReader readerCountLines;
    InputStream inputStream;
    BufferedReader bufferedReader;
    //
    EditText edtTextWriter;
    ImageView imageView;
    Button fPButton,endTest;
    boolean flag=false,startTimerFlag=false;
    int intCount =0;
    int intCurrent;
    int spaceNo=0;
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
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_typing);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        txtCourse=findViewById(R.id.txtCourse);
        edtTextWriter=findViewById(R.id.edtTextWriter);
        imageView=findViewById(R.id.imageView);
        fPButton=findViewById(R.id.fPButton);
        endTest=findViewById(R.id.endTest);
        imageView=findViewById(R.id.imageView);
        Intent intent = new Intent(LessonTyping.this,Result.class);
        Bundle extras=getIntent().getExtras();
        String stringVariableName =extras.getString("stringInt");
        //Intent x=getIntent();
        int value=Integer.parseInt(stringVariableName);
        String s =extras.getString("stringInt");
        int x=Integer.parseInt(s);
        //Toast.makeText(this,value, Toast.LENGTH_SHORT).show();
        //timer id's
        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);
        switch(x) {
            case 1:
                //TextFile extraction
                streamCountLines = this.getResources().openRawResource(R.raw.course_one);
                inputStream = this.getResources().openRawResource(R.raw.course_one);

                break;
            case 2:
                streamCountLines = this.getResources().openRawResource(R.raw.words);
                inputStream = this.getResources().openRawResource(R.raw.words);
                break;
            case 3:
                streamCountLines = this.getResources().openRawResource(R.raw.paragraphs);
                inputStream = this.getResources().openRawResource(R.raw.paragraphs);
                break;
            case 4:
                streamCountLines = this.getResources().openRawResource(R.raw.paragraphs);
                inputStream = this.getResources().openRawResource(R.raw.paragraphs);
                break;
            case 5:
                streamCountLines = this.getResources().openRawResource(R.raw.paragraphs);
                inputStream = this.getResources().openRawResource(R.raw.paragraphs);
                break;
            case 6:
                streamCountLines = this.getResources().openRawResource(R.raw.paragraphs);
                inputStream = this.getResources().openRawResource(R.raw.paragraphs);
                break;
            case 7:
                streamCountLines = this.getResources().openRawResource(R.raw.paragraphs);
                inputStream = this.getResources().openRawResource(R.raw.paragraphs);
                break;
            case 8:
                streamCountLines = this.getResources().openRawResource(R.raw.paragraphs);
                inputStream = this.getResources().openRawResource(R.raw.paragraphs);
                break;
            case 9:
                streamCountLines = this.getResources().openRawResource(R.raw.paragraphs);
                inputStream = this.getResources().openRawResource(R.raw.paragraphs);
                break;
            case 10:
                streamCountLines = this.getResources().openRawResource(R.raw.paragraphs);
                inputStream = this.getResources().openRawResource(R.raw.paragraphs);
                break;
            case 11:
                streamCountLines = this.getResources().openRawResource(R.raw.paragraphs);
                inputStream = this.getResources().openRawResource(R.raw.paragraphs);
                break;
            case 12:
                streamCountLines = this.getResources().openRawResource(R.raw.paragraphs);
                inputStream = this.getResources().openRawResource(R.raw.paragraphs);
                break;
            case 13:
                streamCountLines = this.getResources().openRawResource(R.raw.paragraphs);
                inputStream = this.getResources().openRawResource(R.raw.paragraphs);
                break;
            case 14:
                streamCountLines = this.getResources().openRawResource(R.raw.paragraphs);
                inputStream = this.getResources().openRawResource(R.raw.paragraphs);
                break;
            default:
                Toast.makeText(this,"invalid option",Toast.LENGTH_SHORT).show();
        }
        readerCountLines = new BufferedReader(new InputStreamReader(streamCountLines));
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        //count no. of lines in a textfile
        try{
            while(readerCountLines.readLine()!=null){
                intCount++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        //Toast.makeText(this,String.valueOf(intCount).toString(),Toast.LENGTH_SHORT).show();
        textData = new String[intCount];
        try {
            for(int i=0; i<intCount; i++){
                textData[i]=bufferedReader.readLine().trim();
            }
        }catch (Exception f){
            f.printStackTrace();
        }
        txtCourse.setText(textData[0]);
        intCurrent=0;
        //event on button click
        fPButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setVisibility(View.VISIBLE);
            }
        });
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imageView.setVisibility(View.GONE);
//            }
//        });
        //endTest Button
        endTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pauseTimer();
                //Toast.makeText(getApplicationContext(), wrongWord, Toast.LENGTH_SHORT).show();
                //int result=wpm(rightWord,wrongWord,mTimeLeftInMillis);

                //int min=10,max=50;
                //int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
                //int random_int =new Random().nextInt((max - min) + 1) + min;


                //intent.putExtra("key",random_int);
                startActivity(intent);
            }
        });

        for(int i=0; i<intCount; i++){

            edtTextWriter.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    //start Timer
                    if (startTimerFlag==false){
                        startTimer();
                        startTimerFlag = true;
                    }

                    // If the event is a key-down event on the "Space" button
                    if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                            (keyCode == KeyEvent.KEYCODE_ENTER)) {
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
            txtCourse.setTextColor(getResources().getColor(R.color.Green));
            txtCourse.setText(textData[spaceNo]);
            edtTextWriter.setText("");
            flag=true;
            this.rightWord++;
        }
        else{
            txtCourse.setTextColor(getResources().getColor(R.color.Red));
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
        long speed;
        long time=(600000-mTimeLeftInMillis)/(1000*60);
        speed=(rightWord-wrongWord)/time;
        return (int) speed;
    }
}