package com.yxx.tensort;

import java.util.Random;

public class CreatStuScore {

    private static int[] args;

    public static int[] scores(int count) {
        args=new int[count];
        int i = 0;
        while (i < args.length) {
            args[i++] = new Random().nextInt(100);
        }
        return args;
    }

}


