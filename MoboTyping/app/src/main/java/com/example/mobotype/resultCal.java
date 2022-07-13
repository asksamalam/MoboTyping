package com.example.mobotype;

public class resultCal {
    public int resultCal(int r,int w,long t){
        float speed;
        float time=(600000-t)/(1000*60);
        speed=(r-w)/time;
        final int speed1 = (int) speed;
        return speed1;
    }
}
