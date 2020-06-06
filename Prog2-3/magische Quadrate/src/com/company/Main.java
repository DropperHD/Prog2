package com.company;

public class Main {

    public static void main(String[] args) {
	int[][] testquare = MagicSquare.getExample();
	System.out.println(MagicSquare.isMagic(testquare)); //ergibt true denn testsquare ist magisch
    }
}
