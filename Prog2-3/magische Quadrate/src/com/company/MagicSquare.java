package com.company;

public class MagicSquare {

    static int[][] getExample() {
        int[] z1 = {8, 1, 6};
        int[] z2 = {3, 5, 7};
        int[] z3 = {4, 9, 2};
        return new int[][]{z1, z2, z3};
    }

    public static boolean isMagic(int[][] square) {
        checkArguments(square);
        int[] magicNumber = {0};
        return square.length == 0 || checkVertical(square,magicNumber) && checkHorizontal(square, magicNumber) && checkDiagonal(square, magicNumber);
    }

    private static void checkArguments(int[][] square){
        if (square == null) {
            throw new IllegalArgumentException("square cant be null");
        }
        for (int[] rows : square) {
            if (square.length != rows.length) {
                throw new IllegalArgumentException("Not Quadratic");
            }
        }
    }

    private static boolean checkDiagonal(int[][] square, int[] magicNumber) {
        int calc = 0;
        int i = 0;
        for (int[] rows : square) {  //Diagonal
            calc += rows[i];
        }
        return calc == magicNumber[0];
    }


    private static boolean checkHorizontal(int[][] square, int[] magicNumber) {
        for (int[] rows : square) {  //Horizontal
            int calc = 0;
            for (int numbers : rows) {
                calc += numbers;
            }
            if(calc != magicNumber[0]){
                    return false;
            }
        }
        return true;
    }


    private static boolean checkVertical(int[][] square , int[] magicNumber){
        for (int[] rows : square) {  //Vertikal
            if (magicNumber[0] != 0) {
                int calc = 0;
                for (int numbers : rows) {
                    calc += numbers;
                }
                if (calc != magicNumber[0]) {
                    return false;
                }
            } else {
                for (int numbers : rows) {
                    magicNumber[0] += numbers;
                }
            }
        }
        return true;
    }
}