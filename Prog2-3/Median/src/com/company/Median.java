package com.company;

import java.util.Arrays;

public class Median {

    public static double computeMedian(int ... ints){

        if(ints == null){
            throw new IllegalArgumentException("Argument darf nicht null sein");
        }
        if(ints.length == 0){
            throw new IllegalArgumentException("Funktion braucht Argumente");
        }

        Arrays.sort(ints);
        switch (ints.length % 2 ){
            case 1: return ints[ints.length/2];
            case 0: return (ints[ints.length/2-1] + ints[ints.length/2])/2.0;
            default: throw new IllegalArgumentException("Irgendwas ist schief gelaufen");
        }
    }
}
