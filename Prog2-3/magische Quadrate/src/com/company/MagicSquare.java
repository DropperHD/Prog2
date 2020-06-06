package com.company;

public class MagicSquare {

    /**
     * Statische Methode die ein Testquadrat erzeugt
     * @return zweidimensionales int Array das 3x3 groß ist und mit gleichbleibenden Testzahlen gefüllt ist
     */
    static int[][] getExample() {
        int[] z1 = {8, 1, 6};
        int[] z2 = {3, 5, 7};
        int[] z3 = {4, 9, 2};
        return new int[][]{z1, z2, z3};
    }

    /**
     * Überprüft ob ein zweidimensionales Array ein magisches Quadrat ist
     * @param square magisches Quadrat (int[][]) darf nicht null sein
     * @return true wenn es sich um ein magisches Quadrat handelt
     */
    public static boolean isMagic(int[][] square) {
        checkArguments(square);
        int magicNumber = getMagic(square);
        return square.length == 0 || checkVertical(square,magicNumber) && checkHorizontal(square, magicNumber) && checkDiagonal(square, magicNumber);
    }

    /**
     * Überprüft Eingabe-parameter auf Richtigkeit, wirft Exeptions
     * @param square die zu Testende Eingabe
     */
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

    /**
     * Überprüft ob ein Quadrat auf der Diagonalen mit der magicnumber übereinstimmt
     * @param square Quadrat
     * @param magicNumber magische Zahl
     * @return true wenn Diagonal und AntiDiagonal die magicnumber rauskommt
     */
    private static boolean checkDiagonal(int[][] square, int magicNumber) {
        int diagonal = 0;
        int antidiagonal = 0;
        int i = 0;
        for (int[] rows : square) {  //Diagonal
            diagonal += rows[i];
                i++;
        }
        i--;
        for (int[] rows : square) {
            antidiagonal += rows[i];
                i--;
        }
        return diagonal == magicNumber && antidiagonal == magicNumber;
    }

    /**
     * Überprüft in jeder Reihe ob die magische Zahl beim addieren rauskommt
     * @param square Quadrat
     * @param magicNumber magische Zahl
     * @return true wenn Horizontal die magicnumber rauskommt
     */

    private static boolean checkHorizontal(int[][] square, int magicNumber) {
        for (int[] rows : square) {
            int calc = 0;
            for (int numbers : rows) {
                calc += numbers;
            }
            if(calc != magicNumber){
                    return false;
            }
        }
        return true;
    }

    /**
     * Überprüft in jeder Spalte ob die magische Zahl beim addieren rauskommt
     * @param square Quadrat
     * @param magicNumber magicnumber
     * @return true wenn Vertikal die magicnumber rauskommt
     */

    private static boolean checkVertical(int[][] square , int magicNumber){
        int spaltenanzahl = 0;
        for (int numbers : square[0]) {          //Weil es ein Quadrat ist wird einfach die erste Reihe durchgegangen
                int vert = 0;                    //vert ist eine Hifsvariable die bei jeder Spalte resetet wird
                for (int[] rows : square) {      //für alle Spalten wird rows[spaltenanzahl] zusammengezählt
                    vert += rows[spaltenanzahl]; // X 0 0    0 X 0     0 0 X
                }                                // X 0 0 -->0 X 0 --> 0 0 X
                if (vert != magicNumber) {       // X 0 0    0 X 0     0 0 X
                    return false;
                }
                spaltenanzahl++;
            }
        return true;
    }

    private static int getMagic(int[][] square){
        if(square.length == 0)          //falls length = 0 ist , wird nichts berechnet um ArrayOutOfBounds zu vermeiden
            return 0;                   //In der Main wird das dann nochmal abgefangen
        int magicnumber = 0;
        for (int numbers : square[0]) { //da es immer ein Quadrat sein muss reicht es einfach die
            magicnumber += numbers;     //erste Reihe durchzugehen und alle Zahlen zusammenzurechnen
        }
        return magicnumber;
    }
}