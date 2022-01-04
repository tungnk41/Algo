package com.zeros.algo;

import java.util.Date;

public class Timer {
    private static long timeStart;

    public static void start(){
        timeStart = System.currentTimeMillis();
    }

    public static void stop(){
        long timeStop = System.currentTimeMillis();
        long timeElapsed = timeStop - timeStart;
        System.out.println("\nExecution time : " + timeElapsed + " ms");
    }
}
